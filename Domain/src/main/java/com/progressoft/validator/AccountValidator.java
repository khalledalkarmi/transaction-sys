package com.progressoft.validator;

import com.progressoft.model.Transaction;

import java.math.BigDecimal;

public interface AccountValidator {

    boolean isExit(Transaction transaction);

    boolean isValidBalance(Transaction Transaction);
}
