package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.CreateFinanceGroupCommand;
import com.example.demo.domain.deal.events.FinanceGroupCreatedEvent;
import com.example.demo.schemas.Amount;
import com.example.demo.schemas.FinanceDocument;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * Created by Nox on 21/11/20.
 *
 * Finance Group Aggregate
 */
@Aggregate
@NoArgsConstructor
public class FinanceGroup {

    @AggregateIdentifier
    private UUID financeGroupId;

    private Amount.Currency currency;

    private List<FinanceDocument> financeDocumentList = new ArrayList<>();

    @CommandHandler
    public FinanceGroup(CreateFinanceGroupCommand command) {
        apply(new FinanceGroupCreatedEvent(command.getFinanceGroupId(), command.getFinanceDocuments()));
    }

    @EventSourcingHandler
    void on(FinanceGroupCreatedEvent event) {
        this.financeGroupId = event.getFinanceGroupId();
        this.financeDocumentList = event.getFinanceDocumentList();
    }

}
