package com.example.demo.schemas;

import lombok.Value;

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

    private Currency currency;
    private Double value = 0.0;
}
