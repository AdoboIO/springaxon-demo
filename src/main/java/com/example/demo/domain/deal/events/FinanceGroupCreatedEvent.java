package com.example.demo.domain.deal.events;

import com.example.demo.schemas.FinanceDocument;
import lombok.Value;

import java.util.List;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class FinanceGroupCreatedEvent {

    String financeGroupId;

    List<FinanceDocument> financeDocumentList;
}
