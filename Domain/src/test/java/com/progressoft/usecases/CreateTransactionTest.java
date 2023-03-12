package com.progressoft.usecases;

import com.progressoft.model.Transaction;
import com.progressoft.model.TransactionType;
import com.progressoft.repository.TransactionRepository;
import com.progressoft.validator.CreateTransactionValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateTransactionTest {

    @Mock
    TransactionRepository transactionRepository;
    @Mock
    CreateTransactionValidator createTransactionValidator;
    @InjectMocks
    CreateTransaction createTransaction;

    @Test
    public void givenValidTransaction_whenExecute_thenExpectedResultIsReturned(){
        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.CREDIT)
                .amount(BigDecimal.TEN)
                .transactionTime(LocalDateTime.now())
                .customerId("1000")
                .accountNumber(99999L)
                .build();
        when(createTransactionValidator.validate(transaction)).thenReturn(Collections.emptyList());
        createTransaction.execute(transaction);
        verify(transactionRepository).save(transaction);
    }
}