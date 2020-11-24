package com.example.demo.domain.deal.lookups;

/**
 * Created by Nox on 24/11/20.
 */
public enum DealSagaState {
    STARTED,
    DEAL_PROCESSING,
    DOC_PROCESSING,
    FIN_GROUPING,
    FIN_PROCESSING,
    CHARGE_PROCESSING,
    COMPLETING,
    ENDED
}
