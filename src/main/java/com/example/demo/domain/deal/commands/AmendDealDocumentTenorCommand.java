package com.example.demo.domain.deal.commands;

import com.example.demo.schemas.Tenor;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class AmendDealDocumentTenorCommand {

    @TargetAggregateIdentifier
    UUID dealId;

    String documentId;

    Tenor tenor;
}
