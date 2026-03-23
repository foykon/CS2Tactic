package com.cs2tactic.api.common.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.cs2tactic.api.common.dto.ErrorDataResult;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(CoreException.class)
    public ResponseEntity<ErrorDataResult<ProblemDetail>> handleCoreException(CoreException ex) {
        ProblemDetail problemDetail = createProblemDetail(ex.getErrorCode(), ex.getArgs());
        return ResponseEntity
                .status(ex.getErrorCode().getHttpStatus())
                .body(new ErrorDataResult<>(problemDetail, problemDetail.getDetail()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDataResult<ProblemDetail>> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, String> validationErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage
                ));

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle(resolveMessage(GeneralErrorCode.VALIDATION_ERROR.getTitleKey()));
        problemDetail.setDetail(resolveMessage(GeneralErrorCode.VALIDATION_ERROR.getMessageKey()));
        problemDetail.setProperty("code", GeneralErrorCode.VALIDATION_ERROR.getCode());
        problemDetail.setProperty("errors", validationErrors);
        problemDetail.setProperty("timestamp", OffsetDateTime.now());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDataResult<>(problemDetail, problemDetail.getDetail()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDataResult<ProblemDetail>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        ProblemDetail problemDetail = createProblemDetail(GeneralErrorCode.VALIDATION_ERROR);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDataResult<>(problemDetail, problemDetail.getDetail()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDataResult<ProblemDetail>> handleUnexpectedException(Exception ex) {
        ProblemDetail problemDetail = createProblemDetail(GeneralErrorCode.INTERNAL_SERVER_ERROR);
        log.error("UNEXPECTED ERROR: ", ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDataResult<>(problemDetail, problemDetail.getDetail()));
    }

    private ProblemDetail createProblemDetail(BaseErrorCode errorCode, Object... args) {
        String message = resolveMessage(errorCode.getMessageKey(), args);
        String title = resolveMessage(errorCode.getTitleKey());

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(errorCode.getHttpStatus(), message);
        problem.setTitle(title);

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