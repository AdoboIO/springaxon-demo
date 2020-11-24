package com.example.demo.domain.deal.events;

import com.example.demo.domain.deal.lookups.DealState;
import lombok.Value;
import org.axonframework.serialization.Revision;

import java.util.UUID;

/**
 * Created by Nox on 24/11/20.
 */
@Value
@Revision("1.0")
public class DealIssuedEvent implements  DealEvent {

    UUID dealId;
    UUID requestId;
    DealState dealState;

}
