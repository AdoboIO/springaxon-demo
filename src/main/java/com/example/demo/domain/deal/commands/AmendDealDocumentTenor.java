package com.example.demo.domain.deal.commands;

import com.example.demo.schemas.Term;
import lombok.Value;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class AmendDealDocumentTenor {

    public final String dealId;

    public final String documentId;

    public final Term term;
}
