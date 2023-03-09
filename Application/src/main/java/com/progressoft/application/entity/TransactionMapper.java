package com.progressoft.application.entity;

import com.progressoft.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionMapper {
    public TransactionEntity toTransactionEntity(Transaction transaction) {
        return new TransactionEntity.TransactionEntityBuilder()
                .id(transaction.getId())
                .accountNumber(transaction.getAccountNumber())
                .transactionType(transaction.getTransactionType())
                .transactionTime(transaction.getTransactionTime())
                .amount(transaction.getAmount())
                .customerId(transaction.getCustomerId())
                .build();
    }

    public Transaction toTransaction(TransactionEntity transactionEntity) {
        return Transaction.builder()
                .id(transactionEntity.getId())
                .accountNumber(transactionEntity.getAccountNumber())
                .transactionType(transactionEntity.getTransactionType())
                .amount(transactionEntity.getAmount())
                .customerId(transactionEntity.getCustomerId())
                .transactionTime(transactionEntity.getTransactionTime())
                .build();
    }
}
