package com.example.demo.domain.deal.sagas;

import com.example.demo.domain.deal.commands.CompleteRequestCommand;
import com.example.demo.domain.deal.commands.InitiateDealCommand;
import com.example.demo.domain.deal.commands.IssueDealCommand;
import com.example.demo.domain.deal.events.*;
import com.example.demo.domain.deal.lookups.DealSagaState;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.invoke.MethodHandles;
import java.util.UUID;

/**
 * Created by Nox on 21/11/20.
 */
@Saga
@ProcessingGroup("InitiateDealSaga")
public class InitiateDealSaga  {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private transient CommandGateway commandGateway;
    private UUID requestId;
    private DealSagaState state;

    @StartSaga
    @SagaEventHandler(associationProperty = "requestId")
    public void on(RequestCreatedEvent event) {
        logger.debug("orchestrating {}, starting SAGA", event);
        this.requestId = event.getRequestId();
        this.state = DealSagaState.STARTED;
        UUID dealId = UUID.randomUUID();
        commandGateway.send(new InitiateDealCommand(dealId, event.getRequestId()));
    }

    @SagaEventHandler(associationProperty = "requestId")
    public void on(DealRegisteredEvent event) {
        logger.debug("orchestrating {}", event);
        this.state = DealSagaState.DEAL_PROCESSING;
        commandGateway.send(new IssueDealCommand(event.getDealId(), event.getRequestId()));
    }


    @SagaEventHandler(associationProperty = "requestId")
    public void on(DealIssuedEvent event) {
        logger.debug("orchestrating {}", event);
        this.state = DealSagaState.COMPLETING;
        commandGateway.send(new CompleteRequestCommand(event.getRequestId()));
    }

    @EndSaga
    @SagaEventHandler(associationProperty = "requestId")
    public void on(RequestCompletedEvent event) {
        logger.debug("orchestrating {}, ending SAGA", event);

        // Not required. But all good things must come to an end.
        this.state = DealSagaState.ENDED;
    }

    /*
    void on(DealRegisteredEvent event) {
        UUID documentId = UUID.randomUUID();
        commandGateway.send(new CreateDocumentCommand(documentId,
                new Amount(Amount.Currency.PHP, BigDecimal.valueOf(100.00)),
                Term.TERM30));
    }
    */

    /*
    @EventHandler
    void on(DocumentGroupCreatedEvent event) {

    }
     */

}
