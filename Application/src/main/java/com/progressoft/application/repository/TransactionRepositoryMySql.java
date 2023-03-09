package com.progressoft.application.repository;

import com.progressoft.application.entity.TransactionMapper;
import com.progressoft.model.Transaction;
import com.progressoft.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
public class TransactionRepositoryMySql implements TransactionRepository {
    private final JpaTransactionRepository transactionRepository;

    private final TransactionMapper mapper;

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(mapper.toTransactionEntity(transaction));
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository
                .findAll()
                .stream()
                .map(mapper::toTransaction)
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> findByAccountNumber(Long accountNumber) {
        return transactionRepository
                .findAllByAccountNumber(accountNumber)
                .stream()
                .map(mapper::toTransaction)
                .collect(Collectors.toList());
    }
}
