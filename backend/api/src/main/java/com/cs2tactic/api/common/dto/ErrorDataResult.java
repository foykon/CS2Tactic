package com.cs2tactic.api.common.dto;

public class ErrorDataResult<T> extends DataResult<T> {
    public ErrorDataResult(T data) {
        super(data, false, "An error occurred!");
    }

    public ErrorDataResult(T data, String message) {
        super(data, false, message);
    }
}
