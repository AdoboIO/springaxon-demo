package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.CompleteRequestCommand;
import com.example.demo.domain.deal.commands.CreateRequestCommand;
import com.example.demo.domain.deal.events.RequestCompletedEvent;
import com.example.demo.domain.deal.events.RequestCreatedEvent;
import com.example.demo.domain.deal.lookups.RequestType;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * Created by Nox on 23/11/20.
 *
 * Request Aggregate
 */
@Aggregate
@NoArgsConstructor
public class Request {

   private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

   @AggregateIdentifier
   private UUID requestId;

   private RequestType requestType;

   @CommandHandler
   public Request(CreateRequestCommand command) {
      logger.debug("handling {}", command);
      apply(new RequestCreatedEvent(command.getRequestId(), command.getRequestType()));
   }

   @CommandHandler
   void handle(CompleteRequestCommand command) {
      logger.debug("handling {}", command);
      apply(new RequestCompletedEvent(command.getRequestId()));
   }


   @EventSourcingHandler
   void on(RequestCreatedEvent event) {
      this.requestId = event.getRequestId();
      this.requestType = event.getRequestType();
   }

   @EventSourcingHandler
   void on(RequestCompletedEvent event) {
      this.requestType = RequestType.COMPLETE;
   }

}
