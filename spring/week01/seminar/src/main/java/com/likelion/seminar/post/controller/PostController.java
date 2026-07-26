package com.likelion.seminar.post.controller;

import com.likelion.seminar.post.dto.postDTO;
import com.likelion.seminar.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public void createPost(@RequestBody postDTO postDTO) {
        postService.createPost(postDTO);

    }

    // 게시글 목록 조회
    @GetMapping
    public List<postDTO> getPosts() {
        return postService.getPosts();
    }

    // 게시글 단일 조회 - /post/1
    @GetMapping("/{id}")
    public postDTO getPostByPathVariable (@PathVariable("id") int id, @RequestBody postDTO postDTO) {
        return postService.getPostById(id);
    }

    //게시글 단일 조회 - /post/param?id=1
    @GetMapping("/param")
    public postDTO getPostByRequestParam(@RequestParam("id") int id)  {
        return postService.getPostById(id);
    }

    //게시글 수정
    @PutMapping("/{id}")
    public void updatePost(@PathVariable("id") int id, @RequestBody postDTO postDTO) {
        postService.updatePost(id, postDTO);
    }

    //게시글 삭제
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {
        postService.deletePost(id);
    }
}
