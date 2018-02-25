package com.example.demo.domain.customer;

import com.example.demo.domain.customer.commands.CreateCustomerCommand;
import com.example.demo.domain.customer.events.CustomerCreatedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.saga.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Nox on 2/25/18.
 */
public class CustomerTest {

    private FixtureConfiguration<Customer> fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new AggregateTestFixture<>(Customer.class);
    }


    @Test
    public void testCreateCustomerFixture() {
        fixture.givenNoPriorActivity()
                .when(new CreateCustomerCommand("1234", "Nox"))
                .expectSuccessfulHandlerExecution()
                .expectEvents(new CustomerCreatedEvent());
    }

}