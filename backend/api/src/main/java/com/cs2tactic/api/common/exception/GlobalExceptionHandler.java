package com.cs2tactic.api.common.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    @ExceptionHandler(CoreException.class)
    public ProblemDetail handleCoreException(CoreException ex) {
        return createProblemDetail(ex.getErrorCode(), ex.getArgs());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationErrors(MethodArgumentNotValidException ex) {
        ProblemDetail problem = createProblemDetail(GeneralErrorCode.VALIDATION_ERROR);

        Map<String, String> validationErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                validationErrors.put(error.getField(), error.getDefaultMessage())
        );
        problem.setProperty("errors", validationErrors);

        return problem;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleUnexpectedException(Exception ex) {
        log.error("UNEXPECTED ERROR: ", ex);
        return createProblemDetail(GeneralErrorCode.INTERNAL_SERVER_ERROR);
    }

    private ProblemDetail createProblemDetail(BaseErrorCode errorCode, Object... args) {
        String message = resolveMessage(errorCode.getMessageKey(), args);
        String title = resolveMessage(errorCode.getTitleKey());

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(errorCode.getHttpStatus(), message);
        problem.setTitle(title);
        //problem.setType(URI.create("https://doc.furki.com/errors/" + errorCode.getCode()));
        problem.setProperty("code", errorCode.getCode());

        return problem;
    }

    private String resolveMessage(String key, Object... args) {
        try {
            return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            return key;
        }
    }
}
