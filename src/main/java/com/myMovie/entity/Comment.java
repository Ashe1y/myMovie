package com.myMovie.entity;
/*
 *
 *   @Author:max
 *   @Date: 2023/12/13-12-13-20:50
 *
 */

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Comment {

    private long commentId; //评论id

    private long userId;//用户id

    private String commentContent;//评论内容

    private long movieId;//电影id

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")

    private Date commentTime;//评论的时间

    private User commentUser;//评论用户

    public User getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(User commentUser) {
        this.commentUser = commentUser;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", commentContent='" + commentContent + '\'' +
                ", movieId=" + movieId +
                ", commentTime='" + commentTime + '\'' +
                '}';
    }

    public Comment() {
    }
}
