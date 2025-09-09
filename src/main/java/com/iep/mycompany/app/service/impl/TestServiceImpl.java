package com.iep.mycompany.app.service.impl;

import com.iep.commons.enums.BaseGeneralErrorCode;
import com.iep.commons.exception.BaseCustomException;
import com.iep.mycompany.app.domain.entity.Test;
import com.iep.mycompany.app.facade.TestFacade;
import com.iep.mycompany.app.model.request.RequestTest;
import com.iep.mycompany.app.model.response.ResponseTest;
import com.iep.mycompany.app.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestFacade facade;

    /**
     *
     * @param test
     * @return
     */
    @Override
    public ResponseTest save(RequestTest test) {
        try {
            Test save = facade.save(Test.builder().name(test.getName()).build());
            return ResponseTest.builder().id(save.getId()).name(save.getName()).build();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BaseCustomException(e.getMessage(), BaseGeneralErrorCode.GENERAL_ERROR_CODE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
