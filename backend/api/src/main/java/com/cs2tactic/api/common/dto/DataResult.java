package com.cs2tactic.api.common.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class DataResult<T> extends Result {
    private final T data;

    public DataResult(T data, boolean success, String message) {
        super(success, message);
        this.data = data;
    }
}
