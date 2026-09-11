package com.likelion.hw.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    //erd 설계대로 CHAR(36)로 짜기 위해 UUID 사용
    @UuidGenerator
    @Column(name = "user_id", length = 36)
    private String userId;

    private String name;
    private String state;

    // User 1 : N Post
    // 연관관계의 주인은 Post.user
    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();


    public User(String name, String state) {
        this.name = name;
        this.state = state;
    }
}
