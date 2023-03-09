package com.progressoft.application.repository;


import com.progressoft.model.Account;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface AccountClient {
    @RequestLine("GET /{customerId}/{accountNumber}")
    @Headers("Content-Type: application/json")
    Account getAccountByCustomerIdAndAccountNumber(@Param("customerId") String customerId, @Param("accountNumber") long accountNumber);
}
