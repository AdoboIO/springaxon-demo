package com.example.demo.domain.deal.events;

import com.example.demo.domain.deal.lookups.DealState;

import java.util.UUID;

public interface DealEvent {

    UUID getDealId();
    UUID getRequestId();

    DealState getDealState();
}
