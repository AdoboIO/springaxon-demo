package com.example.demo.domain.deal.events;

import com.example.demo.schemas.Amount;
import lombok.Value;
import org.axonframework.serialization.Revision;

import java.util.UUID;

/**
 * Created by Nox on 25/11/20.
 */
@Value
@Revision("1.0")
public class FinanceCreatedEvent {
    UUID financeId;
    Amount  amount;

}
