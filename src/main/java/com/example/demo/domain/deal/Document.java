package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.AmendDocumentTenorCommand;
import com.example.demo.domain.deal.commands.CreateDocumentCommand;
import com.example.demo.domain.deal.events.DocumentCreatedEvent;
import com.example.demo.domain.deal.events.DocumentTenorAmendedEvent;
import com.example.demo.schemas.Amount;
import com.example.demo.schemas.Tenor;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;

import java.lang.invoke.MethodHandles;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * Created by Nox on 2/25/18.
 *
 * Document Aggregate
 */
@Aggregate
@NoArgsConstructor
public class Document {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @AggregateIdentifier
    UUID documentId;

    UUID referenceId;

    private Amount amount;

    private Tenor tenor;

    @CommandHandler
    public Document(CreateDocumentCommand command) {
        logger.debug("handling {}", command);
        apply(new DocumentCreatedEvent(command.getDocumentId(), command.getReferenceId(), command.getAmount(),
                command.getTenor()));
    }

    @CommandHandler
    void handle(AmendDocumentTenorCommand command) {
        logger.debug("handling {}", command);
        Tenor oldTenor = this.tenor;
        apply(new DocumentTenorAmendedEvent(command.getDocumentId(), command.getTenor(), oldTenor));
    }

    @EventSourcingHandler
    void on(DocumentCreatedEvent event) {
        logger.debug("applying {}", event);
        this.documentId = event.getDocumentId();
        this.referenceId = event.getReferenceId();
        this.amount = event.getAmount();
        this.tenor = event.getTenor();
    }

    @EventSourcingHandler
    void on(DocumentTenorAmendedEvent event) {
        logger.debug("applying {}", event);
        this.tenor = event.getNewTenor();
    }

}
