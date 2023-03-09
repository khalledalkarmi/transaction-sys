package com.progressoft.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private Long id;
    private String customerId;
    private Long accountNumber;
    private TransactionType transactionType;
    private BigDecimal amount;
    private LocalDateTime transactionTime;
}
