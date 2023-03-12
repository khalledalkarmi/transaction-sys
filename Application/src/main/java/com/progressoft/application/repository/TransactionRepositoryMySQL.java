package com.progressoft.application.repository;

import com.progressoft.application.entity.TransactionMapper;
import com.progressoft.model.Transaction;
import com.progressoft.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
public class TransactionRepositoryMySQL implements TransactionRepository {
    private final JpaTransactionRepository jpaTransactionRepository;

    private final TransactionMapper mapper;

    @Override
    public void save(Transaction transaction) {
        jpaTransactionRepository.save(mapper.toTransactionEntity(transaction));
    }

    @Override
    public List<Transaction> findAll() {
        return jpaTransactionRepository
                .findAll()
                .stream()
                .map(mapper::toTransaction)
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> findAllByAccountNumberAndCustomerId(Long accountNumber, String customerId){
        return jpaTransactionRepository.findAllByAccountNumberAndCustomerId(accountNumber, customerId)
                .stream()
                .map(mapper::toTransaction)
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> findAllByCustomerId(String customerId) {
        return jpaTransactionRepository.findAllByCustomerId(customerId)
                .stream()
                .map(mapper::toTransaction)
                .collect(Collectors.toList());
    }
}
