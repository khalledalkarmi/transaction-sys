package com.progressoft.application.repository;

import com.progressoft.application.entity.TransactionEntity;
import com.progressoft.model.Transaction;
import com.progressoft.model.TransactionType;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@DataJpaTest
@Transactional
class JpaTransactionRepositoryTest {

    @Autowired
    private JpaTransactionRepository transactionRepository;
    @Autowired
    private TestEntityManager testEntityManager;


    @Test
    void whenFindAllByAccountNumber_thenShouldReturnEmptyList() {
        List<TransactionEntity> all = transactionRepository.findAll();
        Assertions.assertThat(all.isEmpty()).isTrue();
    }


    @Test
    public void whenSave_thenExpectedResult() {
        TransactionEntity save = transactionRepository.save(getTransactionEntity());
        Assertions.assertThat(save).hasFieldOrPropertyWithValue("amount", BigDecimal.TEN);
        List<TransactionEntity> allByAccountNumber = transactionRepository.findAllByCustomerId("1234567891234567L");
        Assertions.assertThat(allByAccountNumber.size()).isEqualTo(1);
        Assertions.assertThat(allByAccountNumber.get(0)).hasFieldOrPropertyWithValue("customerId", "1234567891234567L");
    }

    public TransactionEntity getTransactionEntity() {
        return TransactionEntity.builder()
                .transactionTime(LocalDateTime.now())
                .transactionType(TransactionType.CREDIT)
                .amount(BigDecimal.TEN)
                .customerId("1234567891234567L")
                .id(1L)
                .build();
    }

    public Transaction getTransaction() {
        return Transaction.builder()
                .transactionTime(LocalDateTime.now())
                .transactionType(TransactionType.CREDIT)
                .amount(BigDecimal.TEN)
                .customerId("1234567891234567L")
                .id(1L)
                .build();

    }
}