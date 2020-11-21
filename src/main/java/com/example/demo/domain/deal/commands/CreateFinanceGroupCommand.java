package com.example.demo.domain.deal.commands;

import com.example.demo.domain.deal.Document;
import com.example.demo.schemas.Amount;
import com.example.demo.schemas.FinanceDocument;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class CreateFinanceGroupCommand {

    @NotNull
    String financeGroupId;

    Amount.Currency currency;

    List<FinanceDocument> financeDocuments;
}

