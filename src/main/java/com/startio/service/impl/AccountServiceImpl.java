package com.startio.service.impl;

import com.startio.dal.entities.UserEntity;
import com.startio.dal.mapper.UsersMapper;
import com.startio.dto.UserDto;
import com.startio.repository.UserRepository;
import com.startio.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service("AccountServiceImpl")
public class AccountServiceImpl implements AccountService {

    private final UserRepository userRepository;

    @Autowired
    public AccountServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDto user) {
        userRepository.save(UsersMapper.convertUserDtoToEntity(user));
    }

    @Override
    public void updateUser(UserDto user) {

        Optional<UserEntity> optionalUserEntity = userRepository.findByUsername((user.getUsername()));
        if(optionalUserEntity.isPresent()){
            UserEntity entity = optionalUserEntity.get();
            entity.setPassword(user.getPassword());
            userRepository.saveAndFlush(entity);
        }else{
            //todo User not found handling
            //throw RuntimeException("user not found");
        }
    }

    @Override
    public UserDto getUserByUserName(String username) {

        Optional<UserEntity> optionalUserEntity = userRepository.findByUsername((username));
        if(optionalUserEntity.isPresent()){
            return UsersMapper.convertUserEntityToDto(optionalUserEntity.get());
        }
        //todo Error handling;
        return null;
    }
}
