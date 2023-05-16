package com.startio.controller;


import com.startio.dto.UserDto;
import com.startio.errors.BadRequestException;
import com.startio.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1.0/account")
public class UsersController {

    private final AccountService accountService;

    public UsersController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody UserDto input){

        inputValidation(input);

        accountService.createUser(input);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
                .body(new String("User successfully saved !!!"));
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUser(@RequestParam String username) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
                .body(accountService.getUserByUserName(username));
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody UserDto input){

        inputValidation(input);

        accountService.updateUser(input);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE))
                .body(new String("User successfully updated !!!"));
    }

    private void inputValidation(UserDto input){

        if(input.getPassword() == null || input.getPassword().isBlank()){
            throw new BadRequestException("Password required !");
        }

        if(input.getUsername() == null || input.getUsername().isBlank()){
            throw new BadRequestException("Name can not be empty or null");
        }
    }
}
