package com.myMovie.service.impl;

import com.myMovie.entity.Movie;
import com.myMovie.mapper.CommentMapper;
import com.myMovie.mapper.MovieMapper;
import com.myMovie.mapper.UserMapper;
import com.myMovie.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;
    @Resource
    private MovieMapper movieMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public int addCommentByUser(int userId, String commentContent, int movieId, Date date) {
        int num = commentMapper.insertCommentByUser(userId,commentContent,movieId,date);
        movieMapper.updateCommentCount(movieId,1);
        return num;
    }

    @Override
    public int reviseCommentContextById(int commentId, String commentContext,int userId) {
        if (userMapper.selectUserById(userId) == null) {
            return -1;
        }
        return commentMapper.updateCommentContentById(commentId,commentContext);
    }

    @Override
    @Transactional
    public int deleteCommentById(int commentId, int userId) {
        Movie movie = movieMapper.selectMoveByCommentId(commentId);
        if (userMapper.selectUserById(userId).getUserRole() != 1) {
            return -1;
        }
        int num =  commentMapper.deleteCommentById(commentId);
        movieMapper.updateCommentCount((int)movie.getMovieId(),-1);
        return num;
    }
}
