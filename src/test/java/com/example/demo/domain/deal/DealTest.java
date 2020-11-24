package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.InitiateDealCommand;
import com.example.demo.domain.deal.events.DealRegisteredEvent;
import com.example.demo.domain.deal.lookups.DealState;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

public class DealTest {
    
    private FixtureConfiguration<Deal> fixture;
    
    @Before
    public void setUp() throws Exception {
        fixture = new AggregateTestFixture<>(Deal.class);
    }
    
    @Test
    public void testCreateDealFixture() {
        UUID dealId = UUID.randomUUID();
        UUID requestId = UUID.randomUUID();
        fixture.givenNoPriorActivity()
                .when(new InitiateDealCommand(dealId, requestId))
                .expectSuccessfulHandlerExecution()
                .expectEvents(new DealRegisteredEvent(dealId, requestId, DealState.INITIATED));
    }
}
