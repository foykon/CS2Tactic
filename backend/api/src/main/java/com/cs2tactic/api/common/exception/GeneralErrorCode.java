package com.cs2tactic.api.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum GeneralErrorCode implements BaseErrorCode {

    VALIDATION_ERROR("GEN-400", "general.validation.error", "general.validation.title", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR("GEN-500", "general.unexpected.error", "general.unexpected.title", HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_FOUND("GEN-404", "general.not.found", "general.not.found.title", HttpStatus.NOT_FOUND);

    private final String code;
    private final String messageKey;
    private final String titleKey;
    private final HttpStatus httpStatus;
}
