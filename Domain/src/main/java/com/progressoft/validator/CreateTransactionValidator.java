package com.progressoft.validator;

import com.progressoft.exception.AccountNotFoundException;
import com.progressoft.exception.InvalidTransactionException;
import com.progressoft.exception.NotEnoughBalanceException;
import com.progressoft.exception.Violation;
import com.progressoft.model.Account;
import com.progressoft.model.Transaction;
import lombok.AllArgsConstructor;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class CreateTransactionValidator {
    private final AccountProvider accountProvider;

    public List<Violation> validate(Transaction transaction) {
        List<Violation> violations = new ArrayList<>();
        if (Objects.isNull(transaction)) {
            violations.add(new Violation(new InvalidTransactionException("Null Transaction")));
            return violations;
        }
        if (Objects.isNull(transaction.getAccountNumber()))
            violations.add(new Violation(new AccountNotFoundException("Account Number is null")));
        if (Objects.isNull(transaction.getCustomerId()))
            violations.add((new Violation(new AccountNotFoundException("Customer Id is null"))));
        if (Objects.isNull(transaction.getAmount()) || transaction.getAmount().compareTo(BigDecimal.ZERO) < 0)
            violations.add(new Violation(new InvalidTransactionException("Invalid Amount " + transaction.getAmount())));
        try {
            Account account = accountProvider.getAccount(transaction);
            if(account.getAvailableBalance().compareTo(transaction.getAmount()) < 0)
                violations.add(new Violation(new NotEnoughBalanceException()));
            if(account.getStatus().equals("Inactive"))
                violations.add(new Violation(new AccountNotFoundException("Account is InActive")));
        } catch (RuntimeException ex) {
            violations.add(new Violation(new AccountNotFoundException("Account Not Found From API")));
        }
        return violations;
    }
}
