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
public class CommentDto {

    private Long id;
    private Long userId;
    private String text;
    private Instant created_at;
    private Instant updated_at;
    private Long postId;
}
