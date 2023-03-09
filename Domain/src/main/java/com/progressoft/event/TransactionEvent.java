package com.progressoft.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TransactionEvent {
    private Object payload;
    private String message;
}
