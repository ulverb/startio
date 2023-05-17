package com.startio;

import com.startio.controller.CommentsController;
import com.startio.dto.CommentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CommentsTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private CommentsController commentsController;

	@Test
	public void contextLoads() {
		assertThat(commentsController).isNotNull();
	}

	@Test
	void Comments_POST(){

		CommentDto commentDto = new CommentDto();

		commentDto.setUserId(5L);
		commentDto.setText("Comments from Test for User 5");
		commentDto.setPostId(7L);

		String response = this.restTemplate.postForObject("http://localhost:8080/api/v1.0/comments", commentDto , String.class);

		assertThat(response.equals("Comment successfully saved !!!"));
	}

	@Test
	void Comments_GET(){

		ResponseEntity<CommentDto[]>  response = this.restTemplate.getForEntity("http://localhost:8080/api/v1.0/comments/user/5", CommentDto[].class);

		CommentDto[] comments = response.getBody();

		assertThat(comments[0].getText()).isEqualTo("Comments from Test for User 5");
	}

	@Test
	void Comments_PUT(){

		CommentDto commentDto = new CommentDto();

		commentDto.setId(1L);
		commentDto.setUserId(5L);
		commentDto.setText("Comments from Test for User 5 updated");
		commentDto.setPostId(7L);

		this.restTemplate.put("http://localhost:8080/api/v1.0/comments", commentDto);

		ResponseEntity<CommentDto[]> response = this.restTemplate.getForEntity("http://localhost:8080/api/v1.0/comments/user/5", CommentDto[].class);

		CommentDto[] comments = response.getBody();

		assertThat(comments[0].getText()).isEqualTo("Comments from Test for User 5 updated");
	}
}
