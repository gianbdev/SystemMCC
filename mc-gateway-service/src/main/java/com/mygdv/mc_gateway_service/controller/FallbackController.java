package com.mygdv.mc_gateway_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @RequestMapping("/customers")
    public ResponseEntity<Map<String, String>> customerFallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Collections.singletonMap("message", "Customer service is unavailable. Please try again later"));
    }

    @RequestMapping("/accounts")
    public ResponseEntity<Map<String, String>> accountFallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Collections.singletonMap("message", "Customer service is unavailable. Please try again later"));
    }

    @RequestMapping("/credit-disbursements")
    public ResponseEntity<Map<String, String>> creditDisbursementFallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Collections.singletonMap("message", "Customer service is unavailable. Please try again later"));
    }

}