package com.startio.repository;

import com.startio.dal.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CommentsRepository extends JpaRepository<CommentEntity, Long> {
    Optional<CommentEntity> findById(Long commentId);
    @Query("SELECT c FROM CommentEntity c WHERE c.userId =:userId")
    List<CommentEntity> findByUserId(Long userId);

    @Query("SELECT p FROM CommentEntity p WHERE p.postId =:postId")
    List<CommentEntity> findByPostId(Long postId);

}
