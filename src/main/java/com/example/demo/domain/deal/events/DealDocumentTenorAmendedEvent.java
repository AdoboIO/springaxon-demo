package com.example.demo.domain.deal.events;

import com.example.demo.schemas.Tenor;
import lombok.Value;
import org.axonframework.serialization.Revision;

/**
 * Created by Nox on 21/11/20.
 */
@Value
@Revision("1.0")
public class DealDocumentTenorAmendedEvent {

   public final String documentId;

   public final Tenor tenor;
}
