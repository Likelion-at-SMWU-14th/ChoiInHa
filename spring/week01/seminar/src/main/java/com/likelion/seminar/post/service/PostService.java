package com.likelion.seminar.post.service;


import com.likelion.seminar.post.dto.postDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final List<postDTO> postDTOList;

    public void createPost(postDTO postDTO) {
        this.postDTOList.add(postDTO);
    }

    public List<postDTO> getPosts() {
        return this.postDTOList;
    }

    public postDTO getPostById(int id) {
        return this.postDTOList.get(id);
    }
}
