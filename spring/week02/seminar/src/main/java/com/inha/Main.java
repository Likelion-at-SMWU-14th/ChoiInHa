package com.inha;

import com.inha.bean.Lion;
import com.inha.bean.Person;
import com.inha.config.ProjectConfig;
import com.inha.model.Comment;
import com.inha.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Comment comment = new Comment();
        comment. setAuthor ("inha"); comment.setText("I'm hungry");
        CommentService commentService =
                context.getBean(CommentService.class);
        commentService.publishComment(comment);
        context.close();


    }
}