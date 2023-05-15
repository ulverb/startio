package com.startio;

import com.startio.controller.UsersController;
import com.startio.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StartioApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private UsersController userController;

	@Test
	public void contextLoads() {
		assertThat(userController).isNotNull();
	}

	@Test
	void UserRegistration_POST(){

		UserDto user = new UserDto("User3", "Password3");
		String response = this.restTemplate.postForObject("http://localhost:8080/api/v1.0/account", user , String.class);

		assertThat(response.equals("User Saved !!!"));

	}

	@Test
	void UserRegistration_GET(){

		String username = "User3";

		UserDto response = this.restTemplate.getForObject("http://localhost:8080/api/v1.0/account?username=User3",UserDto.class);

		assertThat(response.getPassword()).isEqualTo("Password3");

	}
}
