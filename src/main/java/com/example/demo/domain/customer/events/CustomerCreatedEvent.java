package com.example.demo.domain.customer.events;

import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotNull;

/**
 * Created by Nox on 2/25/18.
 */
@Value
public class CustomerCreatedEvent implements CustomerEvent {

    private final String customerId;

    private final String customerName;
}
