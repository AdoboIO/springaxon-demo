package com.example.demo.domain.deal.commands;

import lombok.Value;

import javax.validation.constraints.NotNull;

/**
 * Created by Nox on 10/30/20
 */
@Value
public class CreateDealCommand {

    @NotNull
    private final String dealId;

}
