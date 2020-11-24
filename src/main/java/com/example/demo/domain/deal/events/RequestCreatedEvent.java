package com.example.demo.domain.deal.events;

import com.example.demo.domain.deal.lookups.RequestType;
import lombok.Value;
import org.axonframework.serialization.Revision;

import java.util.UUID;

/**
 * Created by Nox on 23/11/20.
 */
@Value
@Revision("1.0")
public class RequestCreatedEvent {

    UUID requestId;

    RequestType requestType;

}
