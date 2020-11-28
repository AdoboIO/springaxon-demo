package com.example.demo.domain.deal.events;

import com.example.demo.schemas.Amount;
import com.example.demo.schemas.Tenor;
import lombok.Value;
import org.axonframework.serialization.Revision;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by Nox on 21/11/20.
 */
@Value
@Revision("1.0")
public class DocumentCreatedEvent {

    @NotNull
    UUID documentId;
    UUID referenceId;

    Amount amount;

    Tenor tenor;
}
