package com.example.demo.schemas;

import lombok.Value;

import java.util.UUID;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class FinanceDocument {
    UUID documentId;
    Amount amount;
}
