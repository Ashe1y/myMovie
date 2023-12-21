package com.myMovie.mapper;

import com.myMovie.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CommentMapper {
    List<Comment> selectCommentByMovieId(int movie);

    int insertCommentByUser(@Param("userId") int userId,
                            @Param("commentContent") String commentContent,
                            @Param("movieId") int movieId,
                            @Param("date") Date date);

    int updateCommentContentById(@Param("commentId") int commentId,@Param("commentContent") String commentContent);

    int deleteCommentById(int commentId);
}
