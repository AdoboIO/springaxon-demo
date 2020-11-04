package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.CreateDealCommand;
import com.example.demo.domain.deal.events.DealCreatedEvent;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateMember;

import java.util.ArrayList;
import java.util.List;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * Created by Nox on 2/25/18.
 *
 * Aggregate
 */
@AllArgsConstructor
public class Deal {

    @AggregateIdentifier
    private String dealId;

    private String state; // Open, Do not disturb

    @AggregateMember
    private List<Document> documents = new ArrayList<>();

    @AggregateMember
    private List<Finance> finances = new ArrayList<>();


    @CommandHandler
    public Deal(CreateDealCommand command) {
        apply(new DealCreatedEvent(command.getDealId()));
    }

    @EventSourcingHandler
    void on(DealCreatedEvent event) {
        this.dealId = event.getDealId();
    }
}
