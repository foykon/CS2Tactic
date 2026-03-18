package com.cs2tactic.api.common.dto;

public class ErrorResult extends Result {
    public ErrorResult() {
        super(false,"An error occurred!");
    }

    public ErrorResult(String message) {
        super(false, message);
    }
}
