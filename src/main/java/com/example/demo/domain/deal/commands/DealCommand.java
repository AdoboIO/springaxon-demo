package com.example.demo.domain.deal.commands;

import java.util.UUID;

/**
 * Created by Nox on 24/11/20.
 */
public interface DealCommand {
    UUID getDealId();
    UUID getRequestId();
}
