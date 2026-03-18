package com.cs2tactic.api.common.dto;



public class SuccessDataResult<T> extends DataResult<T> {
    public SuccessDataResult(T data) {
        super(data, true, "Success!");
    }

    public SuccessDataResult(T data, String message) {
        super(data, true, message);
    }
}
