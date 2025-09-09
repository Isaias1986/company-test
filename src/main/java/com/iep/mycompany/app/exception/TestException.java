package com.iep.mycompany.app.exception;

import com.iep.commons.exception.BaseExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@ControllerAdvice
public class TestException extends BaseExceptionHandler {
    protected TestException(){}
}
