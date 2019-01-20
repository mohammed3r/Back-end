package com.alrabiah.Services;

import com.alrabiah.dto.CommentsDTO;
import org.springframework.http.ResponseEntity;

public interface CommentService {

    ResponseEntity AddComment(CommentsDTO commentsDTO, Long eventid, Long userid);
}
