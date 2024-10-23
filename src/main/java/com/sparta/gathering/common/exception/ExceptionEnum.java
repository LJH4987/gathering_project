package com.sparta.gathering.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionEnum {

    // 공통
    DATA_INTEGRITY_VIOLATION(HttpStatus.BAD_REQUEST, "DATA_INTEGRITY_VIOLATION", "데이터 처리 중 문제가 발생했습니다. 요청을 확인하고 다시 시도해주세요"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", "서버에서 문제가 발생했습니다."),
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "INVALID_INPUT_VALUE", "요청 값이 올바르지 않습니다."),

    // 토큰 관련
    TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, "TOKEN_NOT,FOUND", "토큰을 찾을 수 없습니다."),

    // 유저 관련
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_NOT_FOUND", "사용자를 찾을 수 없습니다."),
    USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "USER_ALREADY_EXISTS", "이미 존재하는 사용자입니다."),
    EMAIL_PASSWORD_MISMATCH(HttpStatus.BAD_REQUEST, "EMAIL_PASSWORD_MISMATCH", "이메일 혹은 비밀번호가 일치하지 않습니다.");

    private final HttpStatus status;
    private final String errorCode;
    private final String message;

    ExceptionEnum(HttpStatus status, String errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }

}