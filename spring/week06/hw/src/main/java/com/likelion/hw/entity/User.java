package com.likelion.hw.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
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

    public User(String name, String state) {
        this.name = name;
        this.state = state;
    }
}
