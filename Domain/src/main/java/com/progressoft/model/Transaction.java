package com.progressoft.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class Transaction {
    private Long id;
    private String customerId;
    private Long accountNumber;
    private TransactionType transactionType;
    private BigDecimal amount;
    private LocalDateTime transactionTime;
}
