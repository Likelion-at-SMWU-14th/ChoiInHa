package com.likelion.hw;

import com.likelion.hw.entity.Board;
import com.likelion.hw.entity.Comment;
import com.likelion.hw.entity.Post;
import com.likelion.hw.entity.User;
import com.likelion.hw.repository.BoardRepository;
import com.likelion.hw.repository.CommentRepository;
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
public class CommentTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void commentTest() {

        // 1. User 생성
        User user = new User(
                "최인하",
                "Active"
        );

        userRepository.save(user);


        // 2. Board 생성
        Board board = new Board(
                "자유게시판",
                "Active"
        );

        boardRepository.save(board);


        // 3. Post 생성
        Post post = new Post(
                "댓글 테스트 게시글",
                "댓글 테스트 게시글 내용입니다.",
                "Active"
        );


        // 4. Post - User / Board 연관관계 설정
        post.setUser(user);
        post.setBoard(board);

        user.getPosts().add(post);
        board.getPosts().add(post);


        // 5. Post 저장
        postRepository.save(post);


        // 6. Comment 생성
        Comment comment1 = new Comment(
                "첫 번째 댓글입니다.",
                "Active"
        );

        Comment comment2 = new Comment(
                "두 번째 댓글입니다.",
                "Active"
        );


        // 7. Comment 연관관계 설정
        comment1.setUser(user);
        comment1.setBoard(board);
        comment1.setPost(post);

        comment2.setUser(user);
        comment2.setBoard(board);
        comment2.setPost(post);


        // 8. 양방향 관계 설정
        user.getComments().add(comment1);
        user.getComments().add(comment2);

        board.getComments().add(comment1);
        board.getComments().add(comment2);

        post.getComments().add(comment1);
        post.getComments().add(comment2);


        // 9. Comment 저장
        commentRepository.save(comment1);
        commentRepository.save(comment2);


        // 10. 영속성 컨텍스트 초기화
        entityManager.flush();
        entityManager.clear();


        // 11. Post 다시 조회
        Post findPost = postRepository.findById(post.getPostId())
                .orElseThrow();


        // 12. Post -> Comment 조회
        System.out.println("게시글 제목 = " + findPost.getTitle());

        for (Comment comment : findPost.getComments()) {
            System.out.println("댓글 내용 = " + comment.getContent());
        }
    }
}