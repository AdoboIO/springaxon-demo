package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.AmendFinanceAmountCommand;
import com.example.demo.domain.deal.commands.CreateFinanceCommand;
import com.example.demo.domain.deal.events.FinanceCreatedEvent;
import com.example.demo.schemas.Amount;
import lombok.AllArgsConstructor;
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
 * Created by Nox on 2/25/18.
 *
 * Finance Aggregate
 */
@Aggregate
@NoArgsConstructor
public class Finance {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @AggregateIdentifier
    private UUID financeId;

    private Amount amount;

    @CommandHandler
    public Finance(CreateFinanceCommand command) {
        logger.debug("handling {}", command);
        apply(new FinanceCreatedEvent(command.getFinanceId(), command.getAmount()));
    }

    @CommandHandler
    void handle(AmendFinanceAmountCommand command) {
        logger.debug("handling {}", command);

    }

    @EventSourcingHandler
    void on(FinanceCreatedEvent event) {
        logger.debug("applying {}", event);
        this.financeId = event.getFinanceId();
        this.amount = event.getAmount();
    }



}