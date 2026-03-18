package com.cs2tactic.api.common.dto;

public class SuccessResult extends Result {
    public SuccessResult() {
        super(true, "Success!");
    }

    public SuccessResult(String message) {
        super(true, message);
    }
}
