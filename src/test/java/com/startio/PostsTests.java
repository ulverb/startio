package com.startio;

import com.startio.controller.PostsController;



import com.startio.dto.PostDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PostsTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private PostsController postsController;

	@Test
	public void contextLoads() {
		assertThat(postsController).isNotNull();
	}

    @Test
    void Posts_POST(){

        PostDto postDto = new PostDto();

        postDto.setUserId(5L);
        postDto.setText("Post from Test for User 5");

        String response = this.restTemplate.postForObject("http://localhost:8080/api/v1.0/posts", postDto , String.class);

        assertThat(response.equals("Post successfully saved !!!"));
    }

//    @Test
//    void Posts_GET(){
//
//        ResponseEntity<PostDto[]> response = this.restTemplate.getForEntity("http://localhost:8080/api/v1.0/posts?userId=5" ,PostDto[].class);
//
//        PostDto[] posts = response.getBody();
//
//        assertThat(posts[0].getText()).isEqualTo("Post from Test for User 5");
//    }
//
//    @Test
//    void Posts_PUT(){
//
//        PostDto post = new PostDto();
//        post.setId(1L);
//        post.setUserId(5L);
//        post.setText("Post from Test for User 5 updated");
//
//        this.restTemplate.put("http://localhost:8080/api/v1.0/posts", post);
//
//        ResponseEntity<PostDto[]> response = this.restTemplate.getForEntity("http://localhost:8080/api/v1.0/posts?userId=5", PostDto[].class );
//
//        PostDto[] posts = response.getBody();
//
//        assertThat(posts[0].getText()).isEqualTo("Post from Test for User 5 updated");
//
//    }
}
