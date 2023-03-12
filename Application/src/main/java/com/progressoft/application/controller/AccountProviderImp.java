package com.progressoft.application.controller;


import com.progressoft.application.repository.AccountClient;
import com.progressoft.model.Account;
import com.progressoft.model.Transaction;
import com.progressoft.validator.AccountProvider;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AccountProviderImp implements AccountProvider {
    private final AccountClient accountClient;
    public Account getAccount(Transaction transaction) {
        Account accountByCustomerIdAndAccountNumber = accountClient.getAccountByCustomerIdAndAccountNumber(transaction.getCustomerId(), transaction.getAccountNumber());
        log.info(accountByCustomerIdAndAccountNumber.toString());
        return accountByCustomerIdAndAccountNumber;
    }

}
