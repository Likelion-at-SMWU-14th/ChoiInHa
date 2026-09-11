package com.likelion.hw.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name = "post_id",length = 36)
    private String postId;

    // Post N : 1 Board
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    // Post N : 1 User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    // 게시글 제목
    private String title;

    // 게시글 내용
    private String content;

    // 게시글 상태
    private String state;

    public Post(String title, String content, String state) {
        this.title = title;
        this.content = content;
        this.state = state;
    }

}
