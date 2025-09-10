package com.iep.mycompany.app.service.impl;

import com.iep.commons.enums.BaseGeneralErrorCode;
import com.iep.commons.exception.BaseCustomException;
import com.iep.mycompany.app.facade.TestFacade;
import com.iep.mycompany.app.mapper.TestMapper;
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
    private final TestMapper mapper;

    /**
     * Método de persistencia
     * @param test
     * @return ResponseTest
     */
    @Override
    public ResponseTest save(RequestTest test) {
        try {
            return mapper.toResponse(facade.save(mapper.toEntity(test)));
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BaseCustomException(e.getMessage(), BaseGeneralErrorCode.GENERAL_ERROR_CODE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
