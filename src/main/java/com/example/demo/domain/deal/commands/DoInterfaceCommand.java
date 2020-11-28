package com.example.demo.domain.deal.commands;

import lombok.Value;

import java.util.UUID;

/**
 * Created by Nox on 25/11/20.
 */
@Value
public class DoInterfaceCommand {

    UUID requestId;
    Boolean success;
}
