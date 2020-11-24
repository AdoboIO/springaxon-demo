package com.example.demo.domain.deal.events;

import com.example.demo.schemas.FinanceDocument;
import lombok.Value;
import org.axonframework.serialization.Revision;

import java.util.List;
import java.util.UUID;

/**
 * Created by Nox on 21/11/20.
 */
@Value
@Revision("1.0")
public class FinanceGroupCreatedEvent {

    UUID financeGroupId;

    List<FinanceDocument> financeDocumentList;
}
