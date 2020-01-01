package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllersConfiguration {

    @Bean
    GreetingController greetingController(){
        return new GreetingController();
    }

    @Bean
    Greeting greeting(){
        return new Greeting(20, "This is Real content");

    }
}
