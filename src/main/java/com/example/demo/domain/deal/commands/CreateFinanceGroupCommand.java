package com.example.demo.domain.deal.commands;

import com.example.demo.domain.deal.Document;
import com.example.demo.schemas.Amount;
import com.example.demo.schemas.FinanceDocument;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class CreateFinanceGroupCommand {

    @TargetAggregateIdentifier
    UUID financeGroupId;

    Amount.Currency currency;

    List<FinanceDocument> financeDocuments;
}

