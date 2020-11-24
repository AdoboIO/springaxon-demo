package com.example.demo.domain.deal.commands;

import com.example.demo.domain.deal.lookups.RequestType;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

/**
 * Created by Nox on 23/11/20.
 */
@Value
public class CreateRequestCommand implements RequestCommand {

    @TargetAggregateIdentifier
    UUID requestId;

    RequestType requestType;
}
