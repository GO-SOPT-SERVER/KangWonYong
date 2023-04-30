package com.sopt.kwy.soptseminar.common.exception;

import com.sopt.kwy.soptseminar.exception.ErrorStatus;

public class SoptConflictException extends SoptException{
    public SoptConflictException(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
