package com.startio.service.impl;

import com.startio.dal.entities.PostEntity;
import com.startio.dal.mapper.PostMapper;
import com.startio.dto.PostDto;
import com.startio.errors.NotFoundException;
import com.startio.repository.PostsRepository;
import com.startio.service.PostsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service("PostsServiceImpl")
public class PostsServiceImpl  implements PostsService{

    private PostsRepository postsRepository;

    @Autowired
    public PostsServiceImpl(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Override
    public void savePost(PostDto input) {
        postsRepository.save(PostEntity.builder()
                .userId(input.getUserId())
                .text(input.getText())
                .created_at(Instant.now()).build());
    }

    @Override
    public void updatePost(PostDto user) {

        Optional<PostEntity> optionalPostEntity = postsRepository.findById(user.getId());
        if(optionalPostEntity.isPresent()) {
            PostEntity entity = optionalPostEntity.get();
            entity.setText(user.getText());
            entity.setUpdated_at(Instant.now());
            postsRepository.saveAndFlush(entity);
        }
    }

    @Override
    public List<PostDto> getPostsByUserId(Long userId) {

        List<PostEntity> listPostEntity = postsRepository.findByUserId((userId));
        if(listPostEntity.size() > 0){
            return PostMapper.createListPostDto(listPostEntity);
        }
        throw new NotFoundException("Post not found !");
    }
}
