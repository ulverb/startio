package com.startio.controller;

import com.startio.dto.PostDto;
import com.startio.service.PostsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1.0/posts")
public class PostsController{

    private PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity savePost(@RequestBody PostDto input) {

        postsService.savePost(input);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
                .body(new String("Post successfully saved !!!"));

    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPosts(@RequestParam Long userId) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
                .body(postsService.getPostsByUserId(userId));
    }
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updatePost(@RequestBody PostDto input){

        postsService.updatePost(input);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
                .body(new String("Post successfully updated !!!"));
    }
}
