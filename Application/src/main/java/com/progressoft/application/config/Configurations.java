package com.progressoft.application.config;

import com.progressoft.application.repository.AccountClient;
import com.progressoft.event.EventPublisher;
import com.progressoft.repository.TransactionRepository;
import com.progressoft.usecases.CreateTransaction;
import com.progressoft.validator.AccountProvider;
import com.progressoft.validator.CreateTransactionValidator;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {
    @Bean
    public CreateTransaction createTransaction(CreateTransactionValidator createTransactionValidator, TransactionRepository transactionRepository, EventPublisher eventPublisher) {
        return new CreateTransaction(createTransactionValidator, transactionRepository, eventPublisher);
    }

    @Bean
    public CreateTransactionValidator createTransactionValidator(AccountProvider accountProvider) {
        return new CreateTransactionValidator(accountProvider);
    }

    @Bean
    public AccountClient accountClient() {
        return Feign.builder().encoder(new GsonEncoder())
                .client(new OkHttpClient())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(AccountClient.class))
                .logLevel(Logger.Level.FULL)
                .target(AccountClient.class, "http://localhost:9090/api/v1/accounts");

    }
}
