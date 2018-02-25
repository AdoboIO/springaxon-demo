package com.example.demo.domain.customer;

import com.example.demo.domain.customer.commands.CreateCustomerCommand;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;

/**
 * Created by Nox on 2/25/18.
 *
 * Aggregate
 */
@NoArgsConstructor
public class Customer {

    @AggregateIdentifier
    private String customerId;

    private String customerName;


    @CommandHandler
    public Customer(CreateCustomerCommand command) {

    }
}
