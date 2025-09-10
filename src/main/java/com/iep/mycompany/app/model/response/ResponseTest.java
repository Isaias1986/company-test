package com.iep.mycompany.app.model.response;

import com.iep.commons.model.BaseResponseDTO;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseTest extends BaseResponseDTO {

    private Long id;
    private String name;

}
