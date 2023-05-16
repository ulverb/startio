package com.startio.service;

import com.startio.dto.PostDto;

import java.util.List;


public interface PostsService {
    void savePost(PostDto input);
    void updatePost(PostDto user);
    List<PostDto> getPostsByUserId(Long userId);
}
