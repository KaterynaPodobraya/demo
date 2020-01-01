package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    Greeting greeting;

    @RequestMapping("/greeting")

    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
    //public @ResponseBody
    //ResponseEntity <Greeting> greeting(@RequestParam(value="name", defaultValue="World") String name) {
      //  return new ResponseEntity<>(new Greeting(counter.incrementAndGet(), String.format(template, name)), HttpStatus.OK);
        System.out.println(name + "    INSIDE CONTROLLER !!!");
        return greeting.getContent();
    }
}
