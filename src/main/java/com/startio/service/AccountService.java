package com.startio.service;

import com.startio.dto.UserDto;

public interface AccountService {

    void createUser(UserDto user);
    void updateUser(UserDto input);
    UserDto getUserByUserName(String username);

}
