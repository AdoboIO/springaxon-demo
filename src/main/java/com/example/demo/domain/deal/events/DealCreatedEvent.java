package com.example.demo.domain.deal.events;

import com.example.demo.domain.deal.states.DealState;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class DealCreatedEvent implements DealEvent {

    public final String dealId;

    public final DealState dealState;

}
