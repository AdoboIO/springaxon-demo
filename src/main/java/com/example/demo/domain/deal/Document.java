package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.CreateDocumentCommand;
import com.example.demo.domain.deal.events.DocumentCreatedEvent;
import com.example.demo.schemas.Amount;
import com.example.demo.schemas.Term;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.EntityId;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;

import javax.validation.constraints.NotNull;
import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * Created by Nox on 2/25/18.
 *
 * Aggregate
 */
@Aggregate
@NoArgsConstructor
@Profile("command")
public class Document {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @AggregateIdentifier
    UUID documentId;

    private Amount amount;

    private Term term;

    @CommandHandler
    public Document(CreateDocumentCommand command) {
        apply(new DocumentCreatedEvent(command.getDocumentId(), command.getAmount(),
                command.getTerm()));
    }

    @EventSourcingHandler
    void on(DocumentCreatedEvent event) {
        this.documentId = event.getDocumentId();
        this.amount = event.getAmount();
        this.term = event.getTerm();
    }

}
