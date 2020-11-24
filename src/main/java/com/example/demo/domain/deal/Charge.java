package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.CreateChargeCommand;
import com.example.demo.domain.deal.events.ChargeCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * Created by Nox on 21/11/20.
 *
 * Charge Aggregate
 */
@Aggregate
@NoArgsConstructor
public class Charge {

    @AggregateIdentifier
    private UUID chargeId;

    @CommandHandler
    public Charge(CreateChargeCommand command) {
        apply(new ChargeCreatedEvent(command.getChargeId()));
    }

    @EventSourcingHandler
    void on(ChargeCreatedEvent event) {
        this.chargeId = event.getChargeId();
    }

}
