package com.sopt.kwy.soptseminar.common.exception;

import com.sopt.kwy.soptseminar.exception.ErrorStatus;

public class SoptNotFoundException extends SoptException{
    public SoptNotFoundException(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
