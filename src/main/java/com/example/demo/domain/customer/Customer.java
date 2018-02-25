package com.example.demo.domain.customer;

import com.example.demo.domain.customer.commands.CreateCustomerCommand;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;

/**
 * Created by Nox on 2/25/18.
 *
 * Aggregate
 */
@NoArgsConstructor
public class Customer {


    @CommandHandler
    public Customer(CreateCustomerCommand command) {

    }
}
