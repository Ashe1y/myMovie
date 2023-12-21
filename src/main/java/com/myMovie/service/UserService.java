package com.myMovie.service;

import com.myMovie.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(int userId);

    List<User> getUserByName(String userName);

    int addUser(User user);

    int reviseUserPwdById(int userId,String newPwd);

    int reviseUserHeadAndEmailById(User user);
}
