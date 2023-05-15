package com.startio.dal.mapper;

import com.startio.dal.entities.UserEntity;
import com.startio.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    public static UserDto convertUserEntityToDto(UserEntity userEntity){
        return UserDto.builder()
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
