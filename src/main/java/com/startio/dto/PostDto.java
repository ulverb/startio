package com.startio.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder", toBuilder = true)
public class PostDto {

    private Long id;
    private long userId;
    private String text;
    private Instant created_at;
    private Instant updated_at;
}
