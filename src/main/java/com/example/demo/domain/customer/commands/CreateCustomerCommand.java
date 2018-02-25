package com.example.demo.domain.customer.commands;

import lombok.Value;

import javax.validation.constraints.NotNull;

/**
 * Created by Nox on 2/25/18.
 */
@Value
public class CreateCustomerCommand {

    private final String customerId;

    @NotNull
    private final String customerName;

}
