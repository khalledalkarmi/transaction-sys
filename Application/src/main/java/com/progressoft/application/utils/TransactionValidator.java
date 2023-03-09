package com.progressoft.application.utils;

import com.progressoft.application.controller.AccountController;
import com.progressoft.model.Transaction;
import com.progressoft.validator.AccountValidator;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class TransactionValidator implements AccountValidator {

    private final AccountController accountController;

    @Override
    public boolean isExit(Transaction transaction) {
        try {
            accountController.getAccounts(transaction.getCustomerId(), transaction.getAccountNumber());
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    @Override
    public boolean isValidBalance(Transaction transaction) {
        try {
            BigDecimal availableBalance = accountController.getAccounts(transaction.getCustomerId(), transaction.getAccountNumber()).getAvailableBalance();
            if (transaction.getAmount().compareTo(availableBalance) < 0)
                return false;
        } catch (Exception exception) {
            return true;
        }
        return true;
    }
}
