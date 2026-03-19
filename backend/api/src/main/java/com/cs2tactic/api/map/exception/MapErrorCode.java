package com.cs2tactic.api.map.exception;

import org.springframework.http.HttpStatus;

import com.cs2tactic.api.common.exception.BaseErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum MapErrorCode implements BaseErrorCode {

    MAP_NOT_FOUND("MAP-404", "map.not.found", "map.not.found.title", HttpStatus.NOT_FOUND),
    MAP_ALREADY_EXISTS("MAP-409", "map.already.exists", "map.already.exists.title", HttpStatus.BAD_REQUEST);
    
    private final String code;
    private final String messageKey;
    private final String titleKey;
    private final HttpStatus httpStatus;
}