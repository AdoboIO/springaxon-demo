package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.AmendFinanceAmountCommand;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;

/**
 * Created by Nox on 2/25/18.
 *
 * Aggregate
 */
@AllArgsConstructor
public class Finance {

    @AggregateIdentifier
    private String financeId;

    private String currency;
    private Double amount;

    @CommandHandler
    public void handle(AmendFinanceAmountCommand command) {

    }


}