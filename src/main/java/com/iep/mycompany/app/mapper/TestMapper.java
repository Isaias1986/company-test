package com.iep.mycompany.app.mapper;


import com.iep.commons.mapper.BaseMapper;
import com.iep.mycompany.app.domain.entity.Test;
import com.iep.mycompany.app.model.request.RequestTest;
import com.iep.mycompany.app.model.response.ResponseTest;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TestMapper extends BaseMapper<ResponseTest,RequestTest,Test> {

}
