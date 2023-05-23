package com.sopt.kwy.soptseminar.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorStatus {
    /*
    BAD_REQUEST
     */
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    VALIDATION_REQUEST_MISSING_EXCEPTION(HttpStatus.BAD_REQUEST, "요청값이 입력되지 않았습니다."),
    INVALID_PASSWORD_EXCEPTION(HttpStatus.BAD_REQUEST,"잘못된 비밀번호가 입력됐습니다."),

    /*
    FORBIDDEN
     */
    FORBIDDEN_EXCEPTION(HttpStatus.FORBIDDEN, "요청 권한이 없습니다."),

    /*
    * NOT_FOUND
    * */
    NOT_FOUND_POST_EXCEPTION(HttpStatus.NOT_FOUND, "존재하지 않는 게시물입니다."),
    NOT_FOUND_USER_EXCEPTION(HttpStatus.NOT_FOUND, "존재하지 않는 유저입니다."),

    /*
    CONFLICT
     */
    CONFLICT_EMAIL_EXCEPTION(HttpStatus.CONFLICT, "이미 등록된 이메일입니다."),
    CONFLICT_NICKNAME_EXCEPTION(HttpStatus.CONFLICT, "이미 등록된 닉네임입니다."),

    /*
    SERVER_ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "예상치 못한 서버 에러가 발생했습니다.")
    ,;


    private final HttpStatus httpStatus;
    private final String message;
}
