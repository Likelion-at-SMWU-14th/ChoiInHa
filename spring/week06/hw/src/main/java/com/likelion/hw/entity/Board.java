package com.likelion.hw.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

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

    public Board(String name, String state) {
        this.name = name;
        this.state = state;
    }

}
