package com.myMovie.controller;

import com.myMovie.entity.Comment;
import com.myMovie.entity.User;
import com.myMovie.service.CommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping("/addCommentByUser")
    @ResponseBody
    public Object addCommentByUser(int movieId,String commentContent,HttpSession session){
        Map map = new HashMap();
        if (session.getAttribute("user") != null) {
            User user = (User)session.getAttribute("user");
            int row = commentService.addCommentByUser((int) user.getUserId(), commentContent,movieId, new Date());
            if (row > 0) {
                map.put("code",0);
            }else {
                map.put("msg","评论失败");
            }
        } else {
            map.put("msg","请登录");
        }
        return map;
    }



    @RequestMapping("/updateComment")
    @ResponseBody
    public Object updateCommentByCommentId(@RequestParam("comment_id")int commentId,@RequestParam("comment_content") String commentContent,HttpSession session){
        User user = (User)session.getAttribute("user");
        System.out.println(commentId+","+commentContent+","+user.getUserId());
        Map map = new HashMap();
        if (user == null) {
            map.put("msg","请登录");
            return map;
        }
        int row = commentService.reviseCommentContextById(commentId, commentContent,(int)user.getUserId());
        if (row == 1) {
            map.put("code",0);
            map.put("msg","修改成功");
        } else if (row == -1) {
            map.put("msg","禁止修改其他用户！！！");
        } else {
            map.put("msg","修改失败,练习管理员");
        }
        return map;
    }


    @RequestMapping("/deleteComment")
    @ResponseBody
    public Object deleteComment(@RequestParam("comment_id") int commentId,HttpSession session){
        System.out.println(commentId);
        Map map = new HashMap();
        User user = (User)session.getAttribute("user");
        if (user == null) {
            map.put("msg","请登录再试");
            return map;
        }
        int row = commentService.deleteCommentById(commentId, (int) user.getUserId());
        if (row == 1) {
            map.put("code",0);
            map.put("msg","删除成功");
        } else if (row == -1) {
            map.put("msg","权限不足删除失败");
        } else {
            map.put("msg","删除失败,联系管理员");
        }
        return map;
    }
}
