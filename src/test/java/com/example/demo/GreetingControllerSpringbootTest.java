package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
//@EnableWebMvc
@SpringBootTest(classes = ControllersConfiguration.class )
class GreetingControllerSpringbootTest {

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
//		Assertions.assertThat(response).contains("Hello, Mishka!");
//		Assertions.assertThat(response).contains("Hello, Kateryna!");
		Assertions.assertThat(response).contains("This is Real content");
	}

}
