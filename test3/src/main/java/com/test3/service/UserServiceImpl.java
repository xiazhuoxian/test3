package com.test3.service;

import com.test3.mapper.UserMapper;
import com.test3.pojo.Paging;
import com.test3.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    //查询数据库中的全部用户
    @Override
    public List<user> check() {
        return userMapper.check();
    }

    //根据id查询表中的的某一个用户
    @Override
    public user checkOne(user user) {
        return userMapper.checkOne(user);
    }

    //向数据库中添加用户
    @Override
    public void addUser(user user) {
        userMapper.addUser(user);
    }

    //根据id删除数据库中的用户
    @Override
    public void deleteUser(user user) {
        userMapper.deleteUser(user);
    }

    //根据id修改用户
    @Override
    public void updateOne(user user) {
        userMapper.updateOne(user);
    }

    @Override
    public List<user> paging(Paging paging) {
        return userMapper.paging(paging);
    }

    @Override
    public int count(Paging paging) {
        return userMapper.count(paging);
    }
}
