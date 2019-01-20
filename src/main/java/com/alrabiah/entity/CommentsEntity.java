package com.alrabiah.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentid;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private UsersEntity userid;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theevent")
    @JsonIgnore
    private EventsEntity theevent;
    private String comment;
    private LocalDateTime commenttime;
    private boolean deleted;

    public long getCommentid() { return commentid; }

    public void setCommentid(long commentid) { this.commentid = commentid; }

    public UsersEntity getUserid() { return userid; }

    public void setUserid(UsersEntity userid) { this.userid = userid;}

    public EventsEntity getTheevent() { return theevent; }

    public void setTheevent(EventsEntity theevent) { this.theevent = theevent; }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }

    public LocalDateTime getCommenttime() { return commenttime; }

    public void setCommenttime(LocalDateTime commenttime) { this.commenttime = commenttime; }

    public boolean isDeleted() { return deleted; }

    public void setDeleted(boolean deleted) { this.deleted = deleted; }
}
