package com.progressoft.application.config;

import com.progressoft.event.EventPublisher;
import com.progressoft.repository.TransactionRepository;
import com.progressoft.usecases.CreateTransaction;
import com.progressoft.validator.AccountProvider;
import com.progressoft.validator.CreateTransactionValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {
    @Bean
    public CreateTransaction createTransaction(CreateTransactionValidator createTransactionValidator, TransactionRepository transactionRepository , EventPublisher eventPublisher) {
        return new CreateTransaction(createTransactionValidator, transactionRepository , eventPublisher);
    }
    @Bean
    public CreateTransactionValidator createTransactionValidator (AccountProvider accountProvider){
        return new CreateTransactionValidator(accountProvider);
    }
}
