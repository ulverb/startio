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

	private static String USERNAME = "USER6";
	private static String PASSWORD = "PASSWORD6";

	@Test
	void UserRegistration_POST(){

		UserDto user = new UserDto();
		user.setUsername(USERNAME);
		user.setPassword(PASSWORD);

		String response = this.restTemplate.postForObject("http://localhost:8080/api/v1.0/account", user , String.class);

		assertThat(response.equals("User Saved !!!"));
	}

	@Test
	void UserRegistration_GET(){

		UserDto response = this.restTemplate.getForObject("http://localhost:8080/api/v1.0/account?username="+USERNAME, UserDto.class);

		assertThat(response.getPassword()).isEqualTo(PASSWORD);
	}

	@Test
	void UserRegistration_PUT(){

		UserDto user = new UserDto();
		user.setUsername(USERNAME);
		user.setPassword(PASSWORD);

		this.restTemplate.put("http://localhost:8080/api/v1.0/account", user);

		UserDto response = this.restTemplate.getForObject("http://localhost:8080/api/v1.0/account?username="+USERNAME, UserDto.class);

		assertThat(response.getPassword()).isEqualTo("NEW_" + PASSWORD);
	}

}
