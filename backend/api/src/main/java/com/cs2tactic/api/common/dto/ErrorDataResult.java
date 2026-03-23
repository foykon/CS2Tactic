package com.cs2tactic.api.common.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult(T data) {
        super(data, false, "An error occurred!");
    }

    public ErrorDataResult(T data, String message) {
        super(data, false, message);
    }

    @Override
    @JsonIgnore
    public LocalDateTime getTimestamp() {
        return super.getTimestamp();
    }
}
