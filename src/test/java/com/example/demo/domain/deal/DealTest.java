package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.CreateDealCommand;
import com.example.demo.domain.deal.events.DealCreatedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;

public class DealTest {
    
    private FixtureConfiguration<Deal> fixture;
    
    @Before
    public void setUp() throws Exception {
        fixture = new AggregateTestFixture<>(Deal.class);
    }
    
    @Test
    public void testCreateDealFixture() {
        fixture.givenNoPriorActivity()
                .when(new CreateDealCommand("12345"))
                .expectSuccessfulHandlerExecution()
                .expectEvents(new DealCreatedEvent("12345"));
    }
}
