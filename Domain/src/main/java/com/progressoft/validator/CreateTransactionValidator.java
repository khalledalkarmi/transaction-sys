package com.progressoft.validator;

import com.progressoft.exception.Violation;
import com.progressoft.model.Transaction;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class CreateTransactionValidator {

    private final AccountValidator accountValidator;

    public List<Violation> validate(Transaction transaction) {
        List<Violation> violations = new ArrayList<>();
        if (Objects.isNull(transaction))
            violations.add(new Violation(new IllegalArgumentException("Null Transaction")));

        return violations;
    }
}
