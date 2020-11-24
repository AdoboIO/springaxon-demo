package com.example.demo.domain.deal.commands;

import com.example.demo.schemas.Term;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class AmendDealDocumentTenor {

    @TargetAggregateIdentifier
    UUID dealId;

    String documentId;

    Term term;
}
