package com.example.demo.domain.deal.events;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class DealCreatedEvent implements DealEvent {

    public final String dealId;

}
