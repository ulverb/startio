package com.startio.service.impl;

import com.startio.dal.entities.CommentEntity;
import com.startio.dal.mapper.CommentMapper;
import com.startio.dto.CommentDto;
import com.startio.errors.NotFoundException;
import com.startio.repository.CommentsRepository;
import com.startio.service.CommentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service("CommentsServiceImpl")
public class CommentsServiceImpl implements CommentsService {
    private CommentsRepository commentsRepository;

    @Autowired
    public CommentsServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public void saveComment(CommentDto input) {
        commentsRepository.save(CommentEntity.builder()
                .postId(input.getPostId())
                .userId(input.getUserId())
                .text(input.getText())
                .created_at(Instant.now()).build());
    }

    @Override
    public void updateComment(CommentDto comment) {

        Optional<CommentEntity> optionalEntity = commentsRepository.findById(comment.getId());

        if(optionalEntity.isPresent()) {
            CommentEntity entityToUpdata = optionalEntity.get();
            entityToUpdata.setText(comment.getText());
            entityToUpdata.setUpdated_at(Instant.now());
            commentsRepository.saveAndFlush(entityToUpdata);
        }
    }

    @Override
    public List<CommentDto> getCommentByPostId(Long postId) {

        List<CommentEntity> listEntity = commentsRepository.findByPostId(postId);
        if(listEntity.size() > 0){
            return CommentMapper.createListCommentDto(listEntity);
        }
        throw new NotFoundException("Comment not found !");
    }

    @Override
    public List<CommentDto> getCommentsByUserId(Long userId) {

        List<CommentEntity> listEntity = commentsRepository.findByUserId(userId);
        if(listEntity.size() > 0){
            return CommentMapper.createListCommentDto(listEntity);
        }
        throw new NotFoundException("Comment not found !");
    }
}
