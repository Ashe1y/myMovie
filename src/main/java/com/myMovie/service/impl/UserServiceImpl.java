package com.myMovie.service.impl;

import com.myMovie.entity.User;
import com.myMovie.mapper.UserMapper;
import com.myMovie.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(int userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public List<User> getUserByName(String userName) {
        System.out.println(userMapper.selectUserByName(userName));
        return userMapper.selectUserByName(userName);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int reviseUserPwdById(int userId, String newPwd) {
        return userMapper.updateUserPwdByUserId(userId,newPwd);
    }

    @Override
    public int reviseUserHeadAndEmailById(User user) {
        return userMapper.updateUserHeadAndEmailById(user);
    }


}
