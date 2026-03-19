package com.cs2tactic.api.common.exception;

import lombok.Getter;

@Getter
public abstract class CoreException extends RuntimeException {

    private final BaseErrorCode errorCode;
    private final Object[] args;

    public CoreException(BaseErrorCode errorCode, Object... args) {
        super(errorCode.getMessageKey());
        this.errorCode = errorCode;
        this.args = args;
    }
}
