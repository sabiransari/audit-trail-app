package com.audittrail.app.controller;

import com.audittrail.app.service.ApiTrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class ApiTrailController {
    @Autowired
    private ApiTrailService apiTrailService;

    @GetMapping("/trail")
    public void getTrail(@RequestParam(required = false) String requestSource,
                         @RequestParam(required = false) String requestMethod,
                         @RequestParam(required = false) String requestPath,
                         @RequestParam(required = false) Boolean successful,
                         @RequestParam(defaultValue = "0") Integer pageNo,
                         @RequestParam(defaultValue = "10") Integer pageSize) {
        apiTrailService.getTrail(requestSource, RequestMethod.valueOf(requestMethod), requestPath, successful,
                PageRequest.of(pageNo, pageSize));
    }
}
