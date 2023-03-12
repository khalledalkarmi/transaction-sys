package com.progressoft.application.entity;

import com.progressoft.application.resources.TransactionRequest;
import com.progressoft.application.resources.TransactionResponse;
import com.progressoft.model.Transaction;
import com.progressoft.model.TransactionType;
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

    public TransactionResponse toResponseTransaction(Transaction transaction) {
        return TransactionResponse.builder()
                .customerId(transaction.getCustomerId())
                .amount(transaction.getAmount())
                .accountNumber(transaction.getAccountNumber())
                .transactionTime(transaction.getTransactionTime())
                .transactionType(transaction.getTransactionType())
                .build();
    }

    public Transaction toTransaction(TransactionRequest transactionRequest) {
        return Transaction.builder()
                .transactionType(TransactionType.valueOf(transactionRequest.transactionType().toUpperCase()))
                .accountNumber(transactionRequest.accountNumber())
                .amount(transactionRequest.amount())
                .customerId(transactionRequest.customerId())
                .build();
    }
}
