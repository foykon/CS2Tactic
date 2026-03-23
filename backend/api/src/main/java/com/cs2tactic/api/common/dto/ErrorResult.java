package com.cs2tactic.api.common.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ErrorResult extends Result {
    public ErrorResult() {
        super(false,"An error occurred!");
    }

    public ErrorResult(String message) {
        super(false, message);
    }

    @Override
    @JsonIgnore
    public LocalDateTime getTimestamp() {
        return super.getTimestamp();
    }
}
