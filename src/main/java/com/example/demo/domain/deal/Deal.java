package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.InitiateDealCommand;
import com.example.demo.domain.deal.commands.IssueDealCommand;
import com.example.demo.domain.deal.events.DealIssuedEvent;
import com.example.demo.domain.deal.events.DealRegisteredEvent;
import com.example.demo.domain.deal.lookups.DealState;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.util.Assert;

import java.lang.invoke.MethodHandles;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * Created by Nox on 2/25/18.
 *
 * Deal Aggregate
 */
@Aggregate
@NoArgsConstructor
public class Deal {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @AggregateIdentifier
    private UUID dealId;

    private DealState state;

    @CommandHandler
    public Deal(InitiateDealCommand command) {
        logger.debug("handling {}", command);
        apply(new DealRegisteredEvent(command.getDealId(), command.getRequestId(), DealState.INITIATED));
    }

    @CommandHandler
    void handle(IssueDealCommand command) {
        logger.debug("handling {}", command);
        Assert.isTrue(this.dealId.compareTo(command.getDealId()) == 0, "Unsupported operation - Deal ID mismatch!");
        apply(new DealIssuedEvent(command.getDealId(), command.getRequestId(), DealState.ACTIVE));
    }


    @EventSourcingHandler
    void on(DealRegisteredEvent event) {
        logger.debug("applying {}", event);
        this.dealId = event.getDealId();
        this.state = event.getDealState();
    }

    @EventSourcingHandler
    void on(DealIssuedEvent event) {
        logger.debug("applying {}", event);
        this.state = event.getDealState();
    }

    private boolean dealIsActive() {
        return DealState.ACTIVE.equals(state);
    }

    private boolean dealsIsBusy() {
        return DealState.PROCESSING.equals(state);
    }

    private boolean dealsIsClosed() {
        return DealState.CLOSED.equals(state);
    }

}
