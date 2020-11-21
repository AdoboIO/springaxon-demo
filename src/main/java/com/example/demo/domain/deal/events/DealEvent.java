package com.example.demo.domain.deal.events;

import com.example.demo.domain.deal.states.DealState;

public interface DealEvent {

    String getDealId();

    DealState getDealState();
}
