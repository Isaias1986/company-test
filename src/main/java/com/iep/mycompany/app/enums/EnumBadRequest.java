package com.iep.mycompany.app.enums;

import com.iep.commons.enums.SubBaseErrorCode;
import org.springframework.http.HttpStatus;

public enum EnumBadRequest implements SubBaseErrorCode {

    RECORD_NOT_FOUND("registro no encontrado",HttpStatus.NOT_FOUND);


    private final String message;
    private final HttpStatus httpStatus;

    EnumBadRequest(final String message, final HttpStatus httpStatus){
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
