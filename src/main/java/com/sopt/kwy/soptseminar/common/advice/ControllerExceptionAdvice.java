package com.sopt.kwy.soptseminar.common.advice;

import com.sopt.kwy.soptseminar.common.dto.ApiResponseDto;
import com.sopt.kwy.soptseminar.common.exception.SoptBadRequestException;
import com.sopt.kwy.soptseminar.common.exception.SoptConflictException;
import com.sopt.kwy.soptseminar.common.exception.SoptForbiddenException;
import com.sopt.kwy.soptseminar.common.exception.SoptNotFoundException;
import com.sopt.kwy.soptseminar.exception.ErrorStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice {
    /*
     * 400 BAD_REQUEST
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponseDto handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ApiResponseDto.error(ErrorStatus.VALIDATION_REQUEST_MISSING_EXCEPTION);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SoptBadRequestException.class)
    protected ApiResponseDto handleSoptBadRequestException(final SoptBadRequestException e) {
        return ApiResponseDto.error(e.getErrorStatus());
    }

    /*
     * 403 FORBIDDEN
     * */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(SoptForbiddenException.class)
    protected ApiResponseDto handleSoptForbiddenException(final SoptForbiddenException e) {
        return ApiResponseDto.error(e.getErrorStatus());
    }

    /*
     * 404 NOT FOUND
     * */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SoptNotFoundException.class)
    protected ApiResponseDto handleSoptNotFoundException(final SoptNotFoundException e) {
        return ApiResponseDto.error(e.getErrorStatus());
    }

    /*
     * 409 CONFLICT
     * */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(SoptConflictException.class)
    protected ApiResponseDto handleSoptConflictException(final SoptConflictException e) {
        return ApiResponseDto.error(e.getErrorStatus());
    }
}
