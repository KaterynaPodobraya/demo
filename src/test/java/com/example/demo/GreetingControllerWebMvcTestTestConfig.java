package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes= GreetingControllerWebMvcTestTestConfig.Conf.class)
class GreetingControllerWebMvcTestTestConfig {

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

	@TestConfiguration
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
