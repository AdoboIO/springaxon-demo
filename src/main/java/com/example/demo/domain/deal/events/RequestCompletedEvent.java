package com.example.demo.domain.deal.events;

import lombok.Value;
import org.axonframework.serialization.Revision;

import java.util.UUID;

/**
 * Created by Nox on 24/11/20.
 */
@Value
@Revision("1.0")
public class RequestCompletedEvent implements RequestEvent{
    UUID requestId;
}
