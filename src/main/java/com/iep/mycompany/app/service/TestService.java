package com.iep.mycompany.app.service;

import com.iep.commons.exception.BaseCustomException;
import com.iep.commons.service.BaseService;
import com.iep.mycompany.app.enums.EnumBadRequest;
import com.iep.mycompany.app.model.request.RequestTest;
import com.iep.mycompany.app.model.response.ResponseTest;
import org.springframework.data.domain.Page;

public interface TestService extends BaseService<ResponseTest, RequestTest,Long> {
    default Page<ResponseTest> list(RequestTest params){
        throw new BaseCustomException(null, EnumBadRequest.METHOD_NOT_AVAILABLE);
    }
}
