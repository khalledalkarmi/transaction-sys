package com.progressoft.application.repository;

import com.progressoft.application.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JpaTransactionRepository extends JpaRepository<TransactionEntity, Long> {

    List<TransactionEntity> findAllByAccountNumber(long l);

    List<TransactionEntity> findAllByCustomerId(String customerId);

    List<TransactionEntity> findAllByAccountNumberAndCustomerId(long accountNumber, String customerId);
}
