package com.startio.repository;

import com.startio.dal.entities.PostEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostsRepository extends JpaRepository<PostEntity, Long> {

    Optional<PostEntity> findById(Long postId);

    @Query("SELECT p FROM PostEntity p WHERE p.id =:userId")
    List<PostEntity> findByUserId(Long userId);
}