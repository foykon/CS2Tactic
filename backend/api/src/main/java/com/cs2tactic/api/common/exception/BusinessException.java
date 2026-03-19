package com.cs2tactic.api.common.exception;

public class BusinessException extends CoreException{
    public BusinessException(BaseErrorCode errorCode, Object... args) {
        super(errorCode, args);
    }

}
