package com.progressoft.application.controller;

import com.progressoft.application.entity.TransactionMapper;
import com.progressoft.application.resources.TransactionRequest;
import com.progressoft.application.resources.TransactionResponse;
import com.progressoft.exception.InvalidTransactionException;
import com.progressoft.model.Transaction;
import com.progressoft.repository.TransactionRepository;
import com.progressoft.usecases.CreateTransaction;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper mapper;
    private final CreateTransaction createTransaction;
    @GetMapping
    public List<TransactionResponse> getAllTransaction() {
        return transactionRepository
                .findAll()
                .stream()
                .map(mapper::toResponseTransaction).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void insert(@RequestBody TransactionRequest transactionRequest) {
        try {
            Transaction transaction = mapper.toTransaction(transactionRequest);
            createTransaction.execute(transaction);
            log.info("Transaction Added {}" , transaction.getCustomerId());
        } catch (IllegalArgumentException ex) {
            throw new InvalidTransactionException("Invalid Transaction Type");
        }
    }

    @GetMapping(value = "{customerId}/{accountNumber}",produces="application/json")
    public List<TransactionResponse> getTransactionByCustomerIdAndAccountNumber(@PathVariable String accountNumber, @PathVariable String customerId) {
        return transactionRepository
                .findAllByAccountNumberAndCustomerId(Long.valueOf(accountNumber), customerId)
                .stream()
                .map(mapper::toResponseTransaction)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "{customerId}",produces="application/json")
    public List<TransactionResponse> getTransactionByCustomerId( @PathVariable String customerId) {
        return transactionRepository
                .findAllByCustomerId( customerId)
                .stream()
                .map(mapper::toResponseTransaction)
                .collect(Collectors.toList());
    }
}
