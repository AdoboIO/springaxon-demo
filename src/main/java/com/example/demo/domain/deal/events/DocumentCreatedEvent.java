package com.example.demo.domain.deal.events;

import com.example.demo.schemas.Amount;
import com.example.demo.schemas.Term;
import lombok.Value;

import javax.validation.constraints.NotNull;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class DocumentCreatedEvent {
    public final String documentId;

    public final Amount amount;

    public final Term term;
}
