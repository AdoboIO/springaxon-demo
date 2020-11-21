package com.example.demo.domain.deal.sagas;

import com.example.demo.domain.deal.Document;
import com.example.demo.domain.deal.commands.CreateDocumentCommand;
import com.example.demo.domain.deal.commands.CreateFinanceGroupCommand;
import com.example.demo.domain.deal.events.DealCreatedEvent;
import com.example.demo.domain.deal.events.DocumentCreatedEvent;
import com.example.demo.domain.deal.events.DocumentGroupCreatedEvent;
import com.example.demo.domain.deal.events.FinanceGroupCreatedEvent;
import com.example.demo.schemas.Amount;
import com.example.demo.schemas.Term;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by Nox on 21/11/20.
 */
public class InitiateDealSaga  {

    @Autowired
    private transient CommandGateway commandGateway;

    @EventHandler
    void on(DealCreatedEvent event) {

        commandGateway.send(new CreateDocumentCommand(UUID.randomUUID().toString(),
                new Amount(Amount.Currency.PHP, BigDecimal.valueOf(100.00)),
                Term.TERM30));
    }

    @EventHandler
    void on(DocumentGroupCreatedEvent event) {
    }
}
