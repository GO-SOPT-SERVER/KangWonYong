package com.sopt.kwy.soptseminar.common.exception;

import com.sopt.kwy.soptseminar.exception.ErrorStatus;

public class SoptBadRequestException extends SoptException{
    public SoptBadRequestException(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
