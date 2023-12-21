package com.myMovie.mapper;

import com.myMovie.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User selectUserById(long userId);

    List<User> selectUserByName(String userName);

    int insertUser(User user);

    int updateUserPwdByUserId(@Param("userId") int userId,@Param("userPwd") String userPwd);

    int updateUserHeadAndEmailById(User user);
}
