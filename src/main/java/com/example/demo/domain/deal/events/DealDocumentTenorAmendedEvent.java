package com.example.demo.domain.deal.events;

import com.example.demo.schemas.Term;
import lombok.Value;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class DealDocumentTenorAmendedEvent {

   public final String documentId;

   public final Term term;
}
