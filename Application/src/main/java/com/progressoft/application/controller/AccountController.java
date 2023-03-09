package com.progressoft.application.controller;


import com.progressoft.application.entity.account.Account;
import com.progressoft.application.repository.AccountClient;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountController {
    public Account getAccounts(String customerId, long accountNumber) {
        AccountClient accountClient = Feign.builder().encoder(new GsonEncoder())
                .client(new OkHttpClient())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(AccountClient.class))
                .logLevel(Logger.Level.FULL)
                .target(AccountClient.class, "http://localhost:9090/api/v1/accounts");

        Account accountByCustomerIdAndAccountNumber = accountClient.getAccountByCustomerIdAndAccountNumber(customerId, accountNumber);
        log.info(accountByCustomerIdAndAccountNumber.toString());
        return accountByCustomerIdAndAccountNumber;
    }

}
