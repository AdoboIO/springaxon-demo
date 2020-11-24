package com.example.demo.domain.deal.dto;

import com.example.demo.domain.deal.lookups.RequestType;
import lombok.Value;

import java.util.UUID;

/**
 * Created by Nox on 23/11/20.
 */
@Value
public class RequestDTO {

    UUID requestId;
    RequestType requestType;
}
