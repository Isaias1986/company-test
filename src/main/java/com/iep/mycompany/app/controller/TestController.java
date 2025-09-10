package com.iep.mycompany.app.controller;

import com.iep.commons.model.BaseHttpResponse;
import com.iep.commons.utils.BaseUtils;
import com.iep.mycompany.app.model.request.RequestTest;
import com.iep.mycompany.app.model.response.ResponseTest;
import com.iep.mycompany.app.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService service;


    @Operation(summary = "Test", description = "Persistencia de registro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Successfully created"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "401",description = "Unauthoreized"),
            @ApiResponse(responseCode = "400",description = "Access Denied"),
            @ApiResponse(responseCode = "400",description = "Not Found"),
            @ApiResponse(responseCode = "400",description = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<BaseHttpResponse<ResponseTest> > save (@RequestBody RequestTest test){
        ResponseTest save = service.save(test);
        return ResponseEntity.created(BaseUtils.getUri("/test")).body(
                BaseHttpResponse
                .<ResponseTest>builder()
                        .httpStatus(HttpStatus.CREATED)
                        .message("success")
                        .timeStamp(LocalDateTime.now())
                        .statusCode(HttpStatus.CREATED.value())
                        .data(save)
                        .build()
        );
    }

}
