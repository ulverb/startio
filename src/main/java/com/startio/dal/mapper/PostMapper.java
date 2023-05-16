package com.startio.dal.mapper;

import com.startio.dal.entities.PostEntity;
import com.startio.dal.entities.UserEntity;
import com.startio.dto.PostDto;
import com.startio.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostDto convertPostEntityToDto(PostEntity postEntity){
        return PostDto.builder()
                .id(postEntity.getId())
                .userId(postEntity.getUserId())
                .text(postEntity.getText())
                .created_at(postEntity.getCreated_at())
                .updated_at(postEntity.getUpdated_at())
                .build();
    }

    public static List<PostDto> createListPostDto(List<PostEntity> postEntitys) {
        return postEntitys.stream().map(PostMapper::convertPostEntityToDto).collect(Collectors.toList());
    }
}
