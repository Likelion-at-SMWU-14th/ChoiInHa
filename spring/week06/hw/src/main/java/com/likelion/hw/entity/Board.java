package com.likelion.hw.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Board extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name = "board_id", length = 36)
    private String boardId;

    @Column(nullable = false)
    private String name;

    private String state;

    // Board 1 : N Post
    // 연관관계의 주인은 Post.board
    @OneToMany(mappedBy = "board")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "board")
    private List<Comment> comments = new ArrayList<>();

    public Board(String name, String state) {
        this.name = name;
        this.state = state;
    }

}
