package com.startio.repository;

import com.startio.dal.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepo extends JpaRepository<UserEntity, Long> {

/*    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findById(String username);*/

}