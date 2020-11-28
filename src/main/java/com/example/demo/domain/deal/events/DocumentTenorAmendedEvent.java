package com.example.demo.domain.deal.events;

import com.example.demo.schemas.Tenor;
import lombok.Value;

import java.util.UUID;

/**
 * Created by Nox on 25/11/20.
 */
@Value
public class DocumentTenorAmendedEvent {

    UUID documentId;

    Tenor oldTenor;
    Tenor newTenor;
}
