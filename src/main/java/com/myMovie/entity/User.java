package com.myMovie.entity;
/*
 *
 *   @Author:max
 *   @Date: 2023/12/13-12-13-20:49
 *
 */

public class User {


    private long userId;//用户id

    private String userName;//用户名

    private String userPwd;//密码

    private String userEmail;//邮箱

    private int userRole;//身份 1 ：管理员  0 普通用户

    private String userHeadImg;//头像

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userRole=" + userRole +
                ", userHeadImg='" + userHeadImg + '\'' +
                '}';
    }

    public User() {
    }
}
