package com.progressoft.usecases;

import com.progressoft.exception.Violation;
import com.progressoft.model.Transaction;
import com.progressoft.repository.TransactionRepository;
import com.progressoft.validator.CreateTransactionValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CreateTransaction {
    private final CreateTransactionValidator createTransactionValidator;
    private final TransactionRepository transactionRepository;

    public void execute(Transaction transaction) {
        List<Violation> violations = createTransactionValidator.validate(transaction);
        if (!violations.isEmpty())
            violations.forEach(violation -> {
                throw violation.getException();
            });

        transactionRepository.save(transaction);
    }
}
