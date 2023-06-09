package com.startio.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder", toBuilder = true)
public class UserDto {

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long userId;
    private String username;
    private String password;
}
