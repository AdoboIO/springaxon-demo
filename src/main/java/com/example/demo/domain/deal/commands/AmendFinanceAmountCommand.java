package com.example.demo.domain.deal.commands;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class AmendFinanceAmountCommand {
    @NotNull
    String financeId;

    String currency;
    Double amount;

}
