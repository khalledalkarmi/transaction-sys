package com.progressoft.repository;

import com.progressoft.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    void save(Transaction transaction);
    List<Transaction> findAll();
    List<Transaction> findByAccountNumber(Long accountNumber);
}
