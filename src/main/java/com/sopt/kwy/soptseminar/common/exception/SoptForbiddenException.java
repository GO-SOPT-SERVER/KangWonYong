package com.sopt.kwy.soptseminar.common.exception;

import com.sopt.kwy.soptseminar.exception.ErrorStatus;

public class SoptForbiddenException extends SoptException{
    public SoptForbiddenException(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
