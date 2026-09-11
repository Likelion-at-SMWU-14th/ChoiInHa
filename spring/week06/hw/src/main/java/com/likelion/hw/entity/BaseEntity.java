package com.likelion.hw.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class BaseEntity {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
