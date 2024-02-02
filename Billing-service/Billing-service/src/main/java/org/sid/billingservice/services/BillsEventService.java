package org.sid.billingservice.services;

import lombok.AllArgsConstructor;
import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.entities.ProductItem;
import org.sid.billingservice.feign.CustomerRestClient;
import org.sid.billingservice.feign.ProductRestClient;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.sid.billingservice.repository.BillRepository;
import org.sid.billingservice.repository.ProductItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

@Service
@AllArgsConstructor
public class BillsEventService {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;
    @Bean
    public Consumer<Bill> BillsEventConsumer()
    {
        /*return (input) -> {
            Customer customer = customerRestClient.getCustomerById(1L);
            Bill bill = new Bill(null, new Date(), null, customer.getId(), null);
            billRepository.save(bill);
            PagedModel<Product> productsPage = productRestClient.pageProducts();
            productsPage.forEach(p -> {
                ProductItem productItem = new ProductItem();
                productItem.setPrice(p.getPrice());
                productItem.setProductId(p.getId());
                productItem.setQuantity(new Random().nextInt(50) + 1);
                productItem.setBill(bill);
                productItemRepository.save(productItem);
            });
            System.out.println("--------------------------");
            System.out.println(input.toString());
            System.out.println("--------------------------");
        };*/
        return (input) -> {

            List<Product> products = productRestClient.pageProducts().getContent().stream().toList();
            Random random = new Random();
            Bill bill = input;
            Customer customer = customerRestClient.getCustomerById(input.getCustomerID());
            bill.setCustomer(customer);
            Bill savedBill = billRepository.save(bill);
            for (int j = 0; j < products.size(); j++)
            {
                if (Math.random() > 0.60)
                {
                    ProductItem productItem = ProductItem.builder()
                            .bill(savedBill)
                            .productId(products.get(j).getId())
                            .price(products.get(j).getPrice())
                            .quantity(random.nextInt(5) + 1)
                            .product(products.get(j))
                            .build();
                    productItemRepository.save(productItem);
                }
            }
            //System.out.println(input.toString());
            System.out.println(customer.toString());
            //System.out.println(savedOrder.toString());
        };
    }

}
