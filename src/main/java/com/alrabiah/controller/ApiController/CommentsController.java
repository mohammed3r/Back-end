package com.alrabiah.controller.ApiController;

import com.alrabiah.Services.CommentService;
import com.alrabiah.dto.CommentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/comments")
public class CommentsController
{
    @Autowired
    private CommentService commentService;


    @PostMapping("/add/{eventid}/{userid}")
    public ResponseEntity AddComment(@RequestBody @Valid CommentsDTO commentsDTO, @PathVariable Long eventid, @PathVariable Long userid, BindingResult result)
    {
        if(result.hasErrors())
        {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return commentService.AddComment(commentsDTO,eventid,userid);
    }
}
