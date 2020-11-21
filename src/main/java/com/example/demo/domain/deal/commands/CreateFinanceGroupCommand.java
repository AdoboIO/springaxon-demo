package com.example.demo.domain.deal.commands;

import lombok.Value;

import javax.validation.constraints.NotNull;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class CreateFinanceGroupCommand {

    @NotNull
    private final String financeGroupId;
}
