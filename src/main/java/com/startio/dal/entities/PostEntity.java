package com.startio.dal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private long userId;

    @Column(length = 256)
    private String text;

    @Column
    private Instant created_at;
    @Column
    private Instant updated_at;
}

