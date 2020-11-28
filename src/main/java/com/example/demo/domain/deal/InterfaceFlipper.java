package com.example.demo.domain.deal;

import com.example.demo.domain.deal.commands.DoInterfaceCommand;
import com.example.demo.domain.deal.events.InterfaceFailedEvent;
import com.example.demo.domain.deal.events.InterfaceSuccessfulEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.gateway.EventGateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * Created by Nox on 25/11/20.
 */
public class InterfaceFlipper {

    @Autowired
    private EventGateway eventGateway;
    private Random random = new Random();

    @CommandHandler
    public void handle(DoInterfaceCommand command) {
         if (random.nextBoolean() == true) {
            eventGateway.publish(new InterfaceSuccessfulEvent(command.getRequestId(), Boolean.TRUE));
         }
         else {
             eventGateway.publish(new InterfaceFailedEvent(command.getRequestId(), Boolean.FALSE));
        }
    }
}
