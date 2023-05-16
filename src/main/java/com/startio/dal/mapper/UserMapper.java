package com.startio.dal.mapper;

import com.startio.dal.entities.UserEntity;
import com.startio.dto.UserDto;
import org.springframework.stereotype.Component;

public class UserMapper {

    public static UserDto convertUserEntityToDto(UserEntity userEntity){
        return UserDto.builder()
                .userId(userEntity.getId())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .build();
    }

    public static UserEntity convertUserDtoToEntity(UserDto userDto){
        return UserEntity.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();
    }
}
