package com.progressoft.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Violation {

    private final RuntimeException exception;
}
