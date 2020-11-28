package com.example.demo.domain.deal.sagas;

import com.example.demo.domain.deal.commands.*;
import com.example.demo.domain.deal.events.*;
import com.example.demo.domain.deal.lookups.DealSagaState;
import com.example.demo.schemas.Amount;
import com.example.demo.schemas.FinanceDocument;
import com.example.demo.schemas.Tenor;
import org.apache.tomcat.jni.Time;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
    private UUID dealId;
    private DealSagaState state;

    @StartSaga
    @SagaEventHandler(associationProperty = "requestId")
    public void on(RequestCreatedEvent event) {
        logger.debug("orchestrating {}, starting SAGA", event);
        this.requestId = event.getRequestId();
        this.state = DealSagaState.DEAL_PROCESSING;
        UUID dealId = UUID.randomUUID();
        this.dealId = dealId;
        commandGateway.send(new InitiateDealCommand(dealId, event.getRequestId()));
    }

    @SagaEventHandler(associationProperty = "requestId")
    public void on(DealRegisteredEvent event) {
        logger.debug("orchestrating {}", event);
        this.state = DealSagaState.DOC_PROCESSING;
        // Docs R' Us
        UUID documentId = UUID.randomUUID();
        SagaLifecycle.associateWith("documentId", String.valueOf(documentId));
        commandGateway.send(new CreateDocumentCommand(documentId, event.getDealId(),
                new Amount(Amount.Currency.PHP, BigDecimal.valueOf(100.00)), Tenor.TERM30));
    }

    @SagaEventHandler(associationProperty = "documentId")
    public void on(DocumentCreatedEvent event) {
        logger.debug("orchestrating {}", event);
        this.state = DealSagaState.FIN_GROUPING;
        UUID financeGroupId = UUID.randomUUID();

        // TODO temporary till we sort out bulk request
        List<FinanceDocument> financeDocumentList = new ArrayList<>();
        financeDocumentList.add(new FinanceDocument(event.getDocumentId(), event.getAmount()));
        SagaLifecycle.associateWith("financeGroupId", String.valueOf(financeGroupId));
        commandGateway.send(new CreateFinanceGroupCommand(financeGroupId, Amount.Currency.PHP, financeDocumentList));
    }

    @SagaEventHandler(associationProperty = "financeGroupId")
    public void on(FinanceGroupCreatedEvent event) {
        logger.debug("orchestrating {}", event);
        this.state = DealSagaState.FIN_PROCESSING;
        UUID financeId = UUID.randomUUID();
        SagaLifecycle.associateWith("financeId", String.valueOf(financeId));
        commandGateway.send(new CreateFinanceCommand(financeId, new Amount(Amount.Currency.PHP, BigDecimal.valueOf(75))));
    }

    @SagaEventHandler(associationProperty = "financeId")
    public void on(FinanceCreatedEvent event) {
        logger.debug("orchestrating {}", event);
        this.state = DealSagaState.CHARGE_PROCESSING;
        UUID chargeId = UUID.randomUUID();
        SagaLifecycle.associateWith("chargeId", String.valueOf(chargeId));
        commandGateway.send(new CreateChargeCommand(chargeId, new Amount(Amount.Currency.PHP, BigDecimal.valueOf(10))));
    }

    @SagaEventHandler(associationProperty = "chargeId")
    public void on(ChargeCreatedEvent event) {
        logger.debug("orchestrating {}", event);
        this.state = DealSagaState.COMPLETING;
        commandGateway.send(new IssueDealCommand(this.dealId, this.requestId));
    }

    @SagaEventHandler(associationProperty = "requestId")
    public void on(DealIssuedEvent event) {
        logger.debug("orchestrating {}", event);
        this.state = DealSagaState.ENDING;
        commandGateway.send(new CompleteRequestCommand(event.getRequestId()));
    }


    @EndSaga
    @SagaEventHandler(associationProperty = "requestId")
    public void on(RequestCompletedEvent event) {
        logger.debug("orchestrating {}, ending SAGA", event);
        // Not required. But all good things must come to an end.
        // SAGA instance gets deleted here...
    }

}
