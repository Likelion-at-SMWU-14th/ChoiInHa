package com.likelion.hw.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name = "post_id",length = 36)
    private String postId;


}
