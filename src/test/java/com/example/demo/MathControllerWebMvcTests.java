package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class MathControllerWebMvcTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void getMultipyer() throws Exception {

		String response = mockMvc.perform(MockMvcRequestBuilders
						.get(URI.create("/calculate"))
						.param("multiplyer", "10")
						.accept(MediaType.APPLICATION_JSON_VALUE))
						.andExpect(status().isOk())
						.andReturn()
						.getResponse()
						.getContentAsString();

		System.out.println(response);
		Assertions.assertThat(response).isEqualTo("50");
	}

}
