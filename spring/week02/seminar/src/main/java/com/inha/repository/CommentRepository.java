package com.inha.repository;

import com.inha.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
