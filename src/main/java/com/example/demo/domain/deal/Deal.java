package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.AmendDealDocumentTenor;
import com.example.demo.domain.deal.commands.CreateDealCommand;
import com.example.demo.domain.deal.events.DealCreatedEvent;
import com.example.demo.domain.deal.events.DealDocumentTenorAmendedEvent;
import com.example.demo.domain.deal.states.DealState;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.util.Assert;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * Created by Nox on 2/25/18.
 *
 * Deal Aggregate
 */
@NoArgsConstructor
@Profile("command")
public class Deal {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @AggregateIdentifier
    private String dealId;

    private DealState state;

    @AggregateMember
    private List<Document> documents = new ArrayList<>();

    @AggregateMember
    private List<FinanceGroup> financeGroups = new ArrayList<>();

    @AggregateMember
    private List<Finance> finances = new ArrayList<>();


    @CommandHandler
    public Deal(CreateDealCommand command) {
        logger.debug("handlling {}", command);
        apply(new DealCreatedEvent(command.getDealId(), DealState.INITIATED));
    }

    @CommandHandler
    void handle(AmendDealDocumentTenor command) {
        Assert.isTrue(dealIsActive(), "Deal state is not active!");
        apply(new DealDocumentTenorAmendedEvent(command.getDocumentId(), command.getTerm()));
    }


    @EventSourcingHandler
    void on(DealCreatedEvent event) {
        logger.debug("applying {}", event);
        this.dealId = event.getDealId();
        this.state = event.getDealState();
    }

    @EventHandler
    void handle(DealCreatedEvent event) {

    }


    private boolean dealIsActive() {
        return DealState.ACTIVE.equals(state);
    }

    private boolean dealsIsBusy() {
        return DealState.PROCESSING.equals(state);
    }

}
