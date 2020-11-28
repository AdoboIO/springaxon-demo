package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.CreateChargeCommand;
import com.example.demo.domain.deal.events.ChargeCreatedEvent;
import com.example.demo.schemas.Amount;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
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
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @AggregateIdentifier
    private UUID chargeId;

    private Amount amount;

    @CommandHandler
    public Charge(CreateChargeCommand command) {
        logger.debug("handling {}", command);
        apply(new ChargeCreatedEvent(command.getChargeId(), command.getAmount()));
    }

    @EventSourcingHandler
    void on(ChargeCreatedEvent event) {
        this.chargeId = event.getChargeId();
        this.amount = event.getAmount();
    }

}
