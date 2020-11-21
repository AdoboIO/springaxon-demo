package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.CreateFinanceGroupCommand;
import com.example.demo.domain.deal.events.FinanceGroupCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;

/**
 * Created by Nox on 21/11/20.
 *
 * Finance Group Aggregate
 */
@NoArgsConstructor
public class FinanceGroup {
    @AggregateIdentifier
    private String financeGroupId;

    @CommandHandler
    public FinanceGroup(CreateFinanceGroupCommand command) {

    }

    @EventSourcingHandler
    void on(FinanceGroupCreatedEvent event) {

    }

}
