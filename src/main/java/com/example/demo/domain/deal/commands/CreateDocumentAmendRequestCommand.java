package com.example.demo.domain.deal.commands;

import com.example.demo.domain.deal.lookups.RequestType;
import com.example.demo.schemas.Tenor;
import lombok.Value;

import java.util.UUID;

/**
 * Created by Nox on 25/11/20.
 */
@Value
public class CreateDocumentAmendRequestCommand implements RequestCommand {

    UUID requestId;

    RequestType requestType;

    UUID documentId;
    Tenor tenor;

}