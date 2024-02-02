package org.sid.custmerservice;

import org.sid.custmerservice.Repositories.CustomerRepository;
import org.sid.custmerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Stream;

@SpringBootApplication
public class CustmerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustmerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository cr, RepositoryRestConfiguration r)
    {
        return args -> {
            r.exposeIdsFor(Customer.class);
            Stream.of("Zahira","Assiya", "Sara", "Hajar").forEach(c -> {
                Customer customer = new Customer();
                customer.setEmail(c.toLowerCase()+"@gmail.com");
                customer.setName(c.toUpperCase());
                cr.save(customer);
            });
        };
    }

}
