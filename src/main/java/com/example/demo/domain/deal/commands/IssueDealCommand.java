package com.example.demo.domain.deal.commands;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

/**
 * Created by Nox on 24/11/20.
 */
@Value
public class IssueDealCommand {

    @TargetAggregateIdentifier
    UUID dealId;
    UUID requestId;
}
