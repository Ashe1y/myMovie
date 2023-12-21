package com.myMovie.controller;

import com.myMovie.entity.User;
import com.myMovie.mapper.UserMapper;
import com.myMovie.service.UserService;
import com.myMovie.tool.MyTool;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    private MyTool tool = new MyTool();

    @RequestMapping("/register")
    @ResponseBody
    public Object userRegister(User user){
        List<User> users = userService.getUserByName(user.getUserName());
        if (users != null && users.size() > 0){
            return "exited";
        }
        int row = userService.addUser(user);
        if (row > 0) {
            return "success";
        }
        return "error";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Object userLogin(String userName, String userPwd, HttpSession session){
        List<User> users = userService.getUserByName(userName);
        Map map = new HashMap();
        if (users != null && users.size() > 0){
            User loginUser = users.get(0);
            if (loginUser.getUserPwd().equals(userPwd)) {
                session.setAttribute("user",loginUser);
                map.put("msg","success");
                map.put("data",loginUser);
            }
        } else {
            map.put("msg","fail");
        }
        return map;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Object userlogout(HttpSession session){
        session.removeAttribute("user");
        return null;
    }

    @RequestMapping("/modifyUserPwd")
    @ResponseBody
    public Object userLogin(String oldPwd,String newPwd,int userId){
        System.out.println(oldPwd+","+newPwd+","+userId);
        User user = userService.getUserById(userId);
        System.out.println(user.getUserPwd());
        String msg="";
        if(user.getUserPwd().equals(oldPwd)) {
            userService.reviseUserPwdById(userId,newPwd);
            msg = "success";
        }
        return msg;
    }

    @RequestMapping("/uploadHeadImg")
    @ResponseBody
    public Object uploadHeadImg(User user, @RequestParam(required = false,name = "file")MultipartFile multipartFile, HttpServletRequest request,HttpSession session){
        Map map = new HashMap();
        map.put("code",1);//默认失败
        String virtualPaths = "upload/head/";
        String oldPath = userService.getUserById((int)user.getUserId()).getUserHeadImg();
        String newPath = "";
        if (multipartFile != null && multipartFile.getContentType().equals("image/jpeg") || multipartFile.getContentType().equals("image/png")) {
            newPath = virtualPaths + System.currentTimeMillis() + multipartFile.getOriginalFilename();
            //获取真实路径
            String newRealPath = request.getServletContext().getRealPath(newPath);
            String oldRealPath = request.getServletContext().getRealPath(oldPath);
            //存图片
            try {
                if (tool.create(multipartFile,newRealPath)) {
                    //删图片
                    if (tool.delete(oldRealPath)) {
                        //删除成功后
                        user.setUserHeadImg(newPath);
                    } else {
                        //老图未被删除 删除新图
                        tool.delete(newRealPath);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int row = userService.reviseUserHeadAndEmailById(user);
        if (row == 1) {
            map.put("code","0");
            session.removeAttribute("user");
            User loginUser = userService.getUserById((int)user.getUserId());
            session.setAttribute("user",loginUser);
            map.put("data",loginUser);
        }
        return map;
    }

}
