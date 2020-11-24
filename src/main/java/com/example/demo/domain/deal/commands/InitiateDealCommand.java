package com.example.demo.domain.deal.commands;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by Nox on 10/30/20
 */
@Value
public class InitiateDealCommand implements DealCommand {

    @TargetAggregateIdentifier
    UUID dealId;
    UUID requestId;

}
