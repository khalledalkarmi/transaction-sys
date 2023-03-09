package com.progressoft.application.entity.account;


import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
@Data
public class Account {
    private long accountNumber;
    private BigDecimal availableBalance;

    private String status;
    private String creationDate;
}

