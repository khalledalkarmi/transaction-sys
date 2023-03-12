package com.progressoft.application.resources;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

public record TransactionRequest(Long accountNumber, String customerId, BigDecimal amount, String transactionType) {
}
