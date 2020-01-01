package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    @RequestMapping("/calculate")
    @PostMapping
    public int calculate(@RequestParam(value="multiplyer", defaultValue="2") int multiplyer) {
        return multiplyer * 5;
    }
}