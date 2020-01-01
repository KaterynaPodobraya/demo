package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class GreetingControllerWebMvcTestConfig {

	@Autowired
	MockMvc mockMvc;

	@Test
	void getGreeting() throws Exception {

		String response = mockMvc.perform(MockMvcRequestBuilders
						.get(URI.create("/greeting"))
						.param("name","Kateryna")
						.accept(MediaType.APPLICATION_JSON_VALUE))
						.andExpect(status().isOk())
						.andReturn()
						.getResponse()
						.getContentAsString();

		System.out.println(response);
		Assertions.assertThat(response).contains("Test Config");
	}

	@Configuration
	 static class Conf{

		@Bean
		Greeting greeting(){
			return new Greeting(3, "Test Config");
		}

		@Bean
		GreetingController greetingController(){
			return new GreetingController();
		}

	}

}
