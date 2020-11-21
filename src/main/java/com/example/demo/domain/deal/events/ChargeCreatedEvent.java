package com.example.demo.domain.deal.events;

import lombok.Value;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class ChargeCreatedEvent {

    public final String chargeId;
}
