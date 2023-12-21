package com.myMovie.service;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface CommentService {
    /**
     *
     * @param userId 用户ID
     * @param commentContent 评论内容
     * @param movieId 电影ID
     * @param date 评论时间
     * @return
     *  0 评论失败
     *  1 评论成功
     */
    int addCommentByUser(int userId,String commentContent,int movieId,Date date);

    /**
     *
     * @param commentId 评论ID
     * @param commentContext 修改后的内容
     * @param userId 用户ID
     * @return
     * -1 用户名不正确
     *  0 修改失败
     *  1 修改成功
     */
    int reviseCommentContextById(int commentId,String commentContext,int userId);

    /**
     * 删除评论
     * @param commentId 评论ID
     * @param userId 用户ID
     * @return
     *  0 删除失败
     *  1 删除成功
     * -1 非管理员删除
     */
    int deleteCommentById(int commentId,int userId);
}
