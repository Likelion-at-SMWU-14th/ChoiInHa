package com.likelion.hw;

import com.likelion.hw.entity.Post;
import com.likelion.hw.entity.User;
import com.likelion.hw.repository.PostRepository;
import com.likelion.hw.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class UserPostTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void userPostTest() {
        User user = new User("최인하","Active");

        userRepository.save(user);

        Post post1 = new Post(
                "1번 게시글",
                "1번 게시글 내용 어쩌구",
                "Active"
        );

        Post post2 = new Post(
                "2번 게시글",
                "2번 게시글 내용 저쩌구",
                "Active"
        );

        post1.setUser(user);
        post2.setUser(user);

        user.getPosts().add(post1);
        user.getPosts().add(post2);

        postRepository.save(post1);
        postRepository.save(post2);

        entityManager.flush();
        entityManager.clear();

        User findUser = userRepository.findById(user.getUserId())
                .orElseThrow();

        System.out.println("사용자 이름 = " + findUser.getName());

        for (Post post : findUser.getPosts()) {
            System.out.println("게시글 제목 = " + post.getTitle());

        }
    }
}
