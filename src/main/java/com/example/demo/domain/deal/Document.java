package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.CreateDocumentCommand;
import com.example.demo.domain.deal.events.DocumentCreatedEvent;
import com.example.demo.schemas.Amount;
import com.example.demo.schemas.Term;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.EntityId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;

import javax.validation.constraints.NotNull;
import java.lang.invoke.MethodHandles;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * Created by Nox on 2/25/18.
 *
 * Aggregate
 */
@NoArgsConstructor
@Profile("command")
public class Document {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @EntityId
    private String documentId;

    private Term term;
    private Amount amount;

    // TODO: Change this to enum
    //private String state; // PendingRM | approved by RM

    @CommandHandler
    public Document(CreateDocumentCommand command) {

        apply(new DocumentCreatedEvent(command.getDocumentId(), command.getAmount(),
                command.getTerm()));
    }

}