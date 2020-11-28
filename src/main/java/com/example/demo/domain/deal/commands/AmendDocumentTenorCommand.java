package com.example.demo.domain.deal.commands;

import com.example.demo.schemas.Tenor;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

/**
 * Created by Nox on 25/11/20.
 */
@Value
public class AmendDocumentTenorCommand implements  DocumentCommand {

    @TargetAggregateIdentifier
    UUID documentId;

    Tenor tenor;
}
