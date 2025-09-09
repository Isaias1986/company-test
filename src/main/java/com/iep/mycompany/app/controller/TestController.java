package com.iep.mycompany.app.controller;

import com.iep.commons.utils.BaseUtils;
import com.iep.mycompany.app.model.request.RequestTest;
import com.iep.mycompany.app.model.response.ResponseTest;
import com.iep.mycompany.app.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService service;

    @PostMapping
    public ResponseEntity<ResponseTest> save (@RequestBody RequestTest test){
        return ResponseEntity.created(BaseUtils.getUri("/test")).body(service.save(test));
    }

}
