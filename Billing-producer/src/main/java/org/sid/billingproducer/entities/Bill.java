package org.sid.billingproducer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.billingproducer.models.Customer;

import java.util.Collection;
import java.util.Date;

@Data @AllArgsConstructor
@NoArgsConstructor
public class Bill {
    private Long id;
    private Date billingDate;
    private Long customerID;
    private Customer customer;
    private Collection<ProductItem> productItems;

}
