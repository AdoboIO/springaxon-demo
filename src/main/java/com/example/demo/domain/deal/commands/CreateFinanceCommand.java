package com.example.demo.domain.deal.commands;

import com.example.demo.schemas.Amount;
import lombok.Value;

import javax.validation.constraints.NotNull;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class CreateFinanceCommand {

    @NotNull
    String financeId;

    Amount amount;
}
