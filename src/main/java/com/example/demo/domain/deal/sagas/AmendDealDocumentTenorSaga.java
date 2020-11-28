package com.example.demo.domain.deal.sagas;

import com.example.demo.domain.deal.commands.InitiateDealCommand;
import com.example.demo.domain.deal.events.RequestCreatedEvent;
import com.example.demo.domain.deal.lookups.DealSagaState;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.invoke.MethodHandles;
import java.util.UUID;

/**
 * Created by Nox on 25/11/20.
 */
public class AmendDealDocumentTenorSaga {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private transient CommandGateway commandGateway;

    private UUID requestId;
    private UUID dealId;
    private DealSagaState state;

    @StartSaga
    @SagaEventHandler(associationProperty = "requestId")
    public void on(RequestCreatedEvent event){
        logger.debug("orchestrating {}, starting SAGA", event);
        this.requestId = event.getRequestId();
        this.state = DealSagaState.DEAL_PROCESSING;
        UUID dealId = UUID.randomUUID();
        this.dealId = dealId;
        commandGateway.send(new InitiateDealCommand(dealId, event.getRequestId()));
    }
}