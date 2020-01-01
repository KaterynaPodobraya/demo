package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GreetingController.class)
class GreetingControllerWebMvcTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	Greeting greeting;

	@Test
	void getGreeting() throws Exception {

		when(greeting.getContent()).thenReturn("Mocked content for GreetingControllerWebMvcTest");
		String response = mockMvc.perform(MockMvcRequestBuilders
						.get(URI.create("/greeting"))
						.param("name","Kateryna")
						.accept(MediaType.APPLICATION_JSON_VALUE))
						.andExpect(status().isOk())
						.andReturn()
						.getResponse()
						.getContentAsString();

		System.out.println(response);
		Assertions.assertThat(response).contains("Mocked content for GreetingControllerWebMvcTest");
	}

}
