package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/test")
public class TestController {
    static Logger logger = Logger.getLogger(TestController.class.getName());

    private final TestFeignClient feignClient;

    public TestController(final TestFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @GetMapping("/first")
    public String first() {
        logger.info("start first");
        feignClient.second();

        logger.info("done first");
        return "first";
    }

    @GetMapping("/second")
    public String second() {
        logger.info("second");
        return "second";
    }
}
