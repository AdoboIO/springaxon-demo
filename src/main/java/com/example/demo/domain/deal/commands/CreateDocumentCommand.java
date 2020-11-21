package com.example.demo.domain.deal.commands;

import com.example.demo.schemas.Amount;
import com.example.demo.schemas.Term;
import lombok.Value;

import javax.validation.constraints.NotNull;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class CreateDocumentCommand {

    @NotNull
    private final String documentId;

    private final Amount amount;

    private final Term term;

}