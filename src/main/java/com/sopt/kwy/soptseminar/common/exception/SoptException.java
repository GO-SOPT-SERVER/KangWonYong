package com.sopt.kwy.soptseminar.common.exception;

import com.sopt.kwy.soptseminar.exception.ErrorStatus;
import lombok.Getter;

@Getter
public class SoptException extends RuntimeException {
    private ErrorStatus errorStatus;

    public SoptException(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.errorStatus = errorStatus;
    }
}
