package com.example.demo.domain.deal;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.EntityId;

import javax.validation.constraints.NotNull;

/**
 * Created by Nox on 2/25/18.
 *
 * Aggregate
 */
@NoArgsConstructor
public class Document {

    @EntityId
    private String documentId;

    private String currency;
    private Double amount;

    private String state; // Pending RM | approved by RM


}
