package com.example.demo.domain.deal.commands;

import com.example.demo.schemas.Amount;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Value
public class AmendFinanceAmountCommand {

    @TargetAggregateIdentifier
    UUID financeId;

    Amount amount;

}
