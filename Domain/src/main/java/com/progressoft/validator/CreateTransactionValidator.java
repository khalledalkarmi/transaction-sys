package com.progressoft.validator;

import com.progressoft.exception.Violation;
import com.progressoft.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CreateTransactionValidator {

    public List<Violation> validate(Transaction transaction) {
        List<Violation> violations = new ArrayList<>();
        if(Objects.isNull(transaction))
            violations.add(new Violation(new IllegalArgumentException("Null Transaction")));
//        if()

        return violations;
    }
}
