package com.example.demo.domain.customer;

import com.example.demo.domain.customer.commands.CreateCustomerCommand;
import com.example.demo.domain.customer.events.CustomerCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;


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

        apply(new CustomerCreatedEvent(command.getCustomerId(), command.getCustomerName()));
    }


    @EventSourcingHandler
    void on(CustomerCreatedEvent event) {
        this.customerId = event.getCustomerId();
        this.customerName = event.getCustomerName();
    }
}
