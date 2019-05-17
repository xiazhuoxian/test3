package com.test3.service;

import com.test3.pojo.Paging;
import com.test3.pojo.user;

import java.util.List;

public interface UserService {
    //查询数据库中的全部用户
    List<user> check();
    //根据id查询表中的的某一个用户
    user checkOne(user user);
    //向数据库中添加用户
    void addUser(user user);
    //根据id删除数据库中的用户
    void deleteUser(user user);
    //根据id修改用户
    void updateOne(user user);

    //分页查询
    List<user> paging(Paging paging);//查询列表
    int count(Paging paging);//查询列表数
}
