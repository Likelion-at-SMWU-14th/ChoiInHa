package com.inha.proxy;

import com.inha.model.Comment;
import com.inha.repository.CommentRepository;
import org.springframework.stereotype.Component;

@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println(
                "Sending notification vai email "+ comment.getText()
        );
    }
}
