package com.example.demo.domain.deal.events;

import lombok.Value;

import java.util.UUID;

/**
 * Created by Nox on 25/11/20.
 */
@Value
public class InterfaceFailedEvent {
    UUID requestId;
    Boolean isSuccessful;
}
