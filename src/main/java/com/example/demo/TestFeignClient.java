package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="testClient", url="http://localhost:8088")
public interface TestFeignClient {
    @RequestMapping(value = "/test/second",
            method = RequestMethod.GET)
    ResponseEntity<String> second();
}