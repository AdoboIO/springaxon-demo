package com.example.demo.schemas;

import lombok.Value;

import java.math.BigDecimal;

/**
 * Created by Nox on 21/11/20.
 */
@Value
public class Amount {

    public enum Currency {
        PHP,
        SGD,
        USD
    }

    Currency currency;
    BigDecimal value;
}
