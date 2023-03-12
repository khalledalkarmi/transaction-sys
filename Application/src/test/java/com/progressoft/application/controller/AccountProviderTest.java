package com.progressoft.application.controller;

import com.progressoft.model.Account;
import com.progressoft.model.Transaction;
import com.progressoft.validator.AccountProvider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AccountProviderTest {


    @MockBean
    AccountProvider accountProvider;


}