package com.progressoft.application.controller;

import com.progressoft.application.entity.TransactionMapper;
import com.progressoft.model.Transaction;
import com.progressoft.model.TransactionType;
import com.progressoft.repository.TransactionRepository;
import com.progressoft.usecases.CreateTransaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = TransactionController.class)
@ExtendWith(SpringExtension.class)
class TransactionControllerTest {

    @MockBean
    TransactionRepository transactionRepository;
    @MockBean
    TransactionMapper transactionMapper;
    @MockBean
    CreateTransaction createTransaction;
    @Autowired
    MockMvc mockMvc;

    @Test
    void whenGetAllTransaction_thenExpectedResultReturned() throws Exception {
        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.CREDIT)
                .amount(BigDecimal.TEN)
                .accountNumber(11111L)
                .transactionTime(LocalDateTime.now())
                .customerId("KHALED")
                .id(2L)
                .build();
        when(transactionRepository.findAll()).thenReturn(List.of(transaction));

        mockMvc.perform(get("/api/v1/transaction")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void givenValidTransaction_whenInsert_thenExpectedResultIsReturned() throws Exception {
        String json = "{\n" +
                "    \"accountNumber\" : \"4083770003618109\",\n" +
                "    \"customerId\" : \"KHALEDKAR\" ,\n" +
                "    \"amount\" : \"100\" ,\n" +
                "    \"transactionType\" : \"Debt\"\n" +
                "}";

        mockMvc.perform(post("/api/v1/transaction")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}