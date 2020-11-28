package com.example.demo.domain.deal.controllers;

import com.example.demo.domain.deal.commands.CreateDocumentAmendRequestCommand;
import com.example.demo.domain.deal.commands.CreateRequestCommand;
import com.example.demo.domain.deal.commands.InitiateDealCommand;
import com.example.demo.domain.deal.dto.RequestDTO;
import com.example.demo.domain.deal.lookups.RequestType;
import com.example.demo.schemas.Tenor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Created by Nox on 23/11/20.
 *
 * Deal Controller
 */
@RestController
public class RequestController {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final CommandGateway commandGateway;

    public RequestController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping(path = "/requests")
    public CompletableFuture<Void> create(@RequestBody RequestDTO requestDTO) {
        logger.debug("receiving {}", requestDTO);
        UUID requestId = (requestDTO.getRequestId() == null) ? UUID.randomUUID() : requestDTO.getRequestId();

        return commandGateway.send(new CreateRequestCommand(requestId, requestDTO.getRequestType()));
    }

    @PostMapping(path = "/requests/{dealId}/{documentId}/amendtenor/{newTenor}")
    public CompletableFuture<Void> amendDealTenor(@PathVariable UUID dealId, UUID documentId, Tenor newTenor) {
        logger.debug("receiving {}, {}, {}", dealId, documentId, newTenor);
        UUID requestId = UUID.randomUUID();
        return commandGateway.send(new CreateDocumentAmendRequestCommand(requestId, RequestType.AMEND,
                documentId, newTenor));
    }

}
