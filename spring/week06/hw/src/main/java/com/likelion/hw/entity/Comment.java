package com.likelion.hw.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name = "comment_id", length = 36)
    private String commentId;

    // Comment N : 1 Post
    // 연관관계의 주인
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    // Comment N : 1 Board
    // 연관관계의 주인
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    // Comment N : 1 User
    // 연관관계의 주인
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String content;

    private String state;

    public Comment(String content, String state) {
        this.content = content;
        this.state = state;
    }
}