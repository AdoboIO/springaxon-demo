package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.AmendFinanceAmountCommand;
import com.example.demo.schemas.Amount;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;

/**
 * Created by Nox on 2/25/18.
 *
 * Finance Aggregate
 */
@NoArgsConstructor
public class Finance {

    @AggregateIdentifier
    private String financeId;

    private Amount amount;

    @CommandHandler
    public void handle(AmendFinanceAmountCommand command) {

    }



}