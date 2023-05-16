package com.startio.dal.mapper;

import com.startio.dal.entities.CommentEntity;
import com.startio.dal.entities.PostEntity;
import com.startio.dto.CommentDto;
import com.startio.dto.PostDto;

import java.util.List;
import java.util.stream.Collectors;

public class CommentMapper {

    public static CommentDto convertCommentEntityToDto(CommentEntity commentEntity){
        return CommentDto.builder()
                .id(commentEntity.getId())
                .userId(commentEntity.getUserId())
                .text(commentEntity.getText())
                .created_at(commentEntity.getCreated_at())
                .updated_at(commentEntity.getUpdated_at())
                .postId(commentEntity.getPostId())
                .build();
    }

    public static List<CommentDto> createListCommentDto(List<CommentEntity> commentEntitys) {
        return commentEntitys.stream().map(CommentMapper::convertCommentEntityToDto).collect(Collectors.toList());
    }
}
