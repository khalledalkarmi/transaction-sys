package com.progressoft.application.controller;


import com.progressoft.application.repository.AccountClient;
import com.progressoft.model.Account;
import com.progressoft.model.Transaction;
import com.progressoft.validator.AccountProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AccountProviderImp implements AccountProvider {

    private final AccountClient accountClient;

    public Account getAccount(Transaction transaction) {
        return accountClient.getAccountByCustomerIdAndAccountNumber(transaction.getCustomerId(), transaction.getAccountNumber());
    }

}
