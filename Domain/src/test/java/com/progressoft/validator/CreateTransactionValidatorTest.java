package com.progressoft.validator;

import com.progressoft.exception.AccountNotFoundException;
import com.progressoft.exception.InvalidTransactionException;
import com.progressoft.exception.Violation;
import com.progressoft.model.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class CreateTransactionValidatorTest {

    CreateTransactionValidator createTransactionValidator = new CreateTransactionValidator();
    @Test
    public void givenInvalidTransaction_whenValidTransaction_thenThrowsReturned(){
        List<Violation> violations = createTransactionValidator.validate(null);
        Assertions.assertEquals(violations.get(0).getException().getClass() , InvalidTransactionException.class);

        Transaction transaction = new Transaction();
        violations = createTransactionValidator.validate(transaction);
        Assertions.assertEquals(violations.get(0).getException().getClass() , AccountNotFoundException.class);

        transaction = Transaction.builder().customerId("12334").build();
        violations = createTransactionValidator.validate(transaction);
        Assertions.assertEquals(violations.get(0).getException().getClass() , AccountNotFoundException.class);
        Assertions.assertEquals(violations.get(0).getException().getMessage() , "Account Number is null");

        transaction = Transaction.builder().customerId("12334").accountNumber(1242414L).build();
        violations = createTransactionValidator.validate(transaction);
        Assertions.assertEquals(violations.get(0).getException().getClass() , InvalidTransactionException.class);
        Assertions.assertEquals(violations.get(0).getException().getMessage() , "Invalid Amount null");
    }

    @Test
    public void givenValidTransaction_whenValidTransaction_thenNoThrowsReturned(){
        Transaction transaction = Transaction.builder()
                .accountNumber(11111L)
                .amount(BigDecimal.TEN)
                .customerId("2222")
                .build();
        List<Violation> violations = createTransactionValidator.validate(transaction);
        Assertions.assertEquals(violations.size() , 0);

    }

}