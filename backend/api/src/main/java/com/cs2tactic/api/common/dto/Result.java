package com.cs2tactic.api.common.dto;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public abstract class Result {
    private final boolean success;
    private final String message;
    private final LocalDateTime timestamp ;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        
    }
}
