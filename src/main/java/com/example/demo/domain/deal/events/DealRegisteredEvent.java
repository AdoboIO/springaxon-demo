package com.example.demo.domain.deal.events;

import com.example.demo.domain.deal.lookups.DealState;
import lombok.Value;
import org.axonframework.serialization.Revision;

import java.util.UUID;

@Value
@Revision("1.0")
public class DealRegisteredEvent implements DealEvent {

    UUID dealId;
    UUID requestId;

    DealState dealState;

}
