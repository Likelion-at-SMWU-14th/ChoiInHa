package com.inha.proxy;

import com.inha.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
