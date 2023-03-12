package com.progressoft.application.resources;

import com.progressoft.model.TransactionType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class TransactionResponse {
    private String customerId;
    private Long accountNumber;
    private TransactionType transactionType;
    private BigDecimal amount;
    private LocalDateTime transactionTime;
}
