package com.progressoft.application.controller;

import com.progressoft.application.entity.TransactionMapper;
import com.progressoft.application.resources.ResponseTransaction;
import com.progressoft.model.Transaction;
import com.progressoft.repository.TransactionRepository;
import com.progressoft.usecases.CreateTransaction;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    public List<ResponseTransaction> getAllTransaction() {
        return transactionRepository
                .findAll()
                .stream()
                .map(mapper::toResponseTransaction).collect(Collectors.toList());
    }

    @PostMapping
    public void insert(@RequestBody Transaction transaction) {
       createTransaction.execute(transaction);
    }
}
