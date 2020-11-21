package com.example.demo.domain.deal.commands;

import com.example.demo.schemas.Amount;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class AmendFinanceAmountCommand {

    @NotNull
    String financeId;

    Amount amount;

}
