package com.example.demo.domain.deal.sagas;

import com.example.demo.domain.deal.commands.CreateDocumentCommand;
import com.example.demo.domain.deal.events.DealCreatedEvent;
import com.example.demo.schemas.Amount;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * Created by Nox on 21/11/20.
 */
public class InitiateDealSaga  {

    @Autowired
    private transient CommandGateway commandGateway;

    @EventHandler
    void on(DealCreatedEvent event) {
    }
}
