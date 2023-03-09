package com.progressoft.validator;

import com.progressoft.model.Account;
import com.progressoft.model.Transaction;

public interface AccountProvider {
    Account getAccount(Transaction transaction);
}
