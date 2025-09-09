package com.iep.mycompany.app.enums;

import com.iep.commons.enums.BaseErrorCode;
import lombok.Getter;

@Getter
public enum ErrorGeneral implements BaseErrorCode {

    ERROR_GENERAL("Ocurrio un error en la persistencia del registro");

    private final String message;

    ErrorGeneral(String message){
        this.message = message;
    }
}
