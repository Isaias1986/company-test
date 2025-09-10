package com.iep.mycompany.app.service.impl;

import com.iep.commons.enums.BaseGeneralErrorCode;
import com.iep.commons.exception.BaseCustomException;
import com.iep.mycompany.app.domain.entity.Test;
import com.iep.mycompany.app.enums.EnumBadRequest;
import com.iep.mycompany.app.facade.TestFacade;
import com.iep.mycompany.app.mapper.TestMapper;
import com.iep.mycompany.app.model.request.RequestTest;
import com.iep.mycompany.app.model.response.ResponseTest;
import com.iep.mycompany.app.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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

    /**
     * Actualizacion de datos
     * @param id
     * @param request
     * @return
     */
    @Override
    public ResponseTest update(Long id, RequestTest request) {
        Test test = this.facade.findById(id)
                .orElseThrow(() -> new BaseCustomException(null,EnumBadRequest.RECORD_NOT_FOUND));
        test.setName(request.getName());
        return mapper.toResponse(this.facade.save(test));
    }


    /**
     * Buscar por id
     * @param id
     * @return
     */
    @Override
    public ResponseTest findById(Long id) {
        return mapper.toResponse(this.facade.findById(id)
                .orElseThrow(() -> new BaseCustomException(null,EnumBadRequest.RECORD_NOT_FOUND)));
    }

    @Override
    public Page<ResponseTest> list(RequestTest params) {
        return null;
    }


    /**
     * Eliminar registro por id
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        this.facade.findById(id)
                .orElseThrow(() -> new BaseCustomException(null,EnumBadRequest.RECORD_NOT_FOUND));
        this.facade.delete(id);
    }


}
