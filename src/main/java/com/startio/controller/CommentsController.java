package com.startio.controller;

import com.startio.dto.CommentDto;
import com.startio.service.CommentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1.0/comments") //("/api/v1.0/posts/{id}/comments")
public class CommentsController {

    private CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveComment(@RequestBody CommentDto input) {

        commentsService.saveComment(input);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
                .body(new String("Comment successfully saved !!!"));

    }

    @RequestMapping(value = "/post/{postId}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable Long postId) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
                .body(commentsService.getCommentByPostId(postId));
    }
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommentDto>> getCommentsByUserId(@PathVariable Long userId) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
                .body(commentsService.getCommentsByUserId(userId));
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateComment(@RequestBody CommentDto input){

        commentsService.updateComment(input);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
                .body(new String("Comment successfully updated !!!"));
    }
}
