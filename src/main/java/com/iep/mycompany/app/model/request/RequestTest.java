package com.iep.mycompany.app.model.request;


import com.iep.commons.model.BaseRequestDTO;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class RequestTest extends BaseRequestDTO {
    private String name;
}
