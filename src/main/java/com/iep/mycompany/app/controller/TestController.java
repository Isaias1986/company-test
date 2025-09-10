package com.iep.mycompany.app.controller;

import com.iep.commons.model.BaseHttpResponse;
import com.iep.commons.utils.BaseUtils;
import com.iep.mycompany.app.model.request.RequestTest;
import com.iep.mycompany.app.model.response.ResponseTest;
import com.iep.mycompany.app.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService service;

    @Operation(summary = "Test", description = "Busqueda de registro por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "401",description = "Unauthoreized"),
            @ApiResponse(responseCode = "403",description = "Access Denied"),
            @ApiResponse(responseCode = "404",description = "Not Found"),
            @ApiResponse(responseCode = "500",description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<BaseHttpResponse<ResponseTest>> findById(
            @PathVariable("id")
           @Parameter(name = "id", description = "Test id")Long id){
        return ResponseEntity.ok(BaseHttpResponse
                .<ResponseTest>builder()
                .httpStatus(HttpStatus.OK)
                .message("success")
                .timeStamp(LocalDateTime.now())
                .statusCode(HttpStatus.OK.value())
                .data(service.findById(id))
                .build());
    }


    @Operation(summary = "Test", description = "Persistencia de registro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Successfully created"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "401",description = "Unauthoreized"),
            @ApiResponse(responseCode = "403",description = "Access Denied"),
            @ApiResponse(responseCode = "404",description = "Not Found"),
            @ApiResponse(responseCode = "500",description = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<BaseHttpResponse<ResponseTest>> save (@RequestBody RequestTest test){
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


    @Operation(summary = "Test", description = "Actualizacion de registro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successfully updated"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "401",description = "Unauthoreized"),
            @ApiResponse(responseCode = "403",description = "Access Denied"),
            @ApiResponse(responseCode = "404",description = "Not Found"),
            @ApiResponse(responseCode = "500",description = "Internal Server Error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<BaseHttpResponse<ResponseTest>> update (
            @PathVariable("id")
            @Parameter(name = "id", description = "Test id")Long id,
            @RequestBody RequestTest test){
        ResponseTest save = service.update(id,test);
        return ResponseEntity.ok(
                BaseHttpResponse
                        .<ResponseTest>builder()
                        .httpStatus(HttpStatus.OK)
                        .message("success")
                        .timeStamp(LocalDateTime.now())
                        .statusCode(HttpStatus.OK.value())
                        .data(save)
                        .build()
        );
    }

    @Operation(summary = "Test", description = "Eliminación de registro por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",description = "Successfully deleted"),
            @ApiResponse(responseCode = "400",description = "Bad Request"),
            @ApiResponse(responseCode = "401",description = "Unauthoreized"),
            @ApiResponse(responseCode = "403",description = "Access Denied"),
            @ApiResponse(responseCode = "404",description = "Not Found"),
            @ApiResponse(responseCode = "500",description = "Internal Server Error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseHttpResponse<ResponseTest>> deleteById(
            @PathVariable("id")
            @Parameter(name = "id", description = "Test id")Long id){
        this.service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(BaseHttpResponse
                .<ResponseTest>builder()
                .httpStatus(HttpStatus.NO_CONTENT)
                .message("success")
                .timeStamp(LocalDateTime.now())
                .statusCode(HttpStatus.NO_CONTENT.value())
                .build());
    }

}
