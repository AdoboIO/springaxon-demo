package com.example.demo.schemas;

import lombok.Value;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class FinanceDocument {
    String documentId;
    Amount amount;
}
