package com.startio.service;

import com.startio.dto.CommentDto;

import java.util.List;

public interface CommentsService {
    void saveComment(CommentDto input);
    void updateComment(CommentDto user);
    List<CommentDto> getCommentByPostId(Long postId);
    List<CommentDto> getCommentsByUserId(Long userId);
}
