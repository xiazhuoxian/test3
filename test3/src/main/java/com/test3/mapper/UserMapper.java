package com.test3.mapper;

import com.test3.pojo.Paging;
import com.test3.pojo.user;

import java.util.List;

public interface UserMapper {
    //查询maventest表中的全部数据
    List<user> check();
    //根据id查询表中的的某一个用户
    user checkOne(user user);
    //向maven表中添加数据
    void addUser(user user);
    //根据ID删除表中的用户
    void deleteUser(user user);
    //根据id修改用户
    void updateOne(user user);

    //分页查询
    List<user> paging(Paging paging);//查询列表
    int count(Paging paging);//查询列表数
}
