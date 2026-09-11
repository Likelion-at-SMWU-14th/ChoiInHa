package com.likelion.hw;

import com.likelion.hw.entity.Board;
import com.likelion.hw.entity.Post;
import com.likelion.hw.repository.BoardRepository;
import com.likelion.hw.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class BoardPostTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void boardPostTest() {

        // 1. Board 생성
        Board board = new Board("자유게시판", "ACTIVE");

        boardRepository.save(board);


        // 2. Post 생성
        Post post1 = new Post(
                "게시글 1",
                "게시글 1 내용입니다.",
                "ACTIVE"
        );

        Post post2 = new Post(
                "게시글 2",
                "게시글 2 내용입니다.",
                "ACTIVE"
        );


        // 3. Board - Post 연관관계 설정
        post1.setBoard(board);
        post2.setBoard(board);

        board.getPosts().add(post1);
        board.getPosts().add(post2);


        // 4. Post 저장
        postRepository.save(post1);
        postRepository.save(post2);


        // 5. 영속성 컨텍스트 초기화
        entityManager.flush();
        entityManager.clear();


        // 6. Board 조회
        Board findBoard = boardRepository.findById(board.getBoardId())
                .orElseThrow();


        // 7. Board -> Post 조회
        System.out.println("게시판 이름 = " + findBoard.getName());

        for (Post post : findBoard.getPosts()) {
            System.out.println("게시글 제목 = " + post.getTitle());
        }
    }
}
