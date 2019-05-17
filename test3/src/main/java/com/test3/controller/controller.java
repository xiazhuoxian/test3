package com.test3.controller;


import com.sun.tools.internal.ws.processor.model.Model;
import com.test3.pojo.Paging;
import com.test3.pojo.user;
import com.test3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class controller {

    @Autowired
    private UserService userService;

    //跳转到增加页面
    @RequestMapping("/addPage")
    private String toAddPage(){
        System.out.println("跳转到增加用户页面");
        return "add";
    }

    //跳转到修改页面
    @RequestMapping("/modify")
    private String toDeletePage(HttpServletRequest request){
        System.out.println("当前要修改的用户的ID为："+request.getParameter("id"));
        user u=new user(Integer.parseInt(request.getParameter("id")));
        user uu=userService.checkOne(u);
        System.out.println("ID："+uu.getId()+"用户名："+uu.getUsername()+"密码："+uu.getPassword()+"性别："+uu.getSex());
        request.setAttribute("user",userService.checkOne(u));
        return "modify";
    }

    //向数据库中添加用户
    @RequestMapping("/db_add")
    private String db_add(@RequestParam(value = "id") int id,
                            @RequestParam(value = "username") String username,
                                    @RequestParam(value = "password") String password,
                                    @RequestParam(value = "sex") int sex){
        user u=new user(id,username,password,sex);
        userService.addUser(u);
        System.out.println("数据库操作:增加");
        return "redirect:/user/paging?pageNumber=1";
    }

    //根据id删除数据库中的用户
    @RequestMapping("/deleteUser")
    private String db_delete(@RequestParam(value = "id") int id){
        user user=new user(id);
        userService.deleteUser(user);
        return "redirect:/user/paging?pageNumber=1";
    }

    //根据id修改用户
    @RequestMapping("/updateOne")
    private String updateOne(@RequestParam(value = "id") int id,
                                @RequestParam(value = "username") String username,
                                @RequestParam(value = "password") String password,
                                @RequestParam(value = "sex") int sex){
        user u=new user(id,username,password,sex);
        userService.updateOne(u);
        return "redirect:/user/paging?pageNumber=1";
    }

    //检查数据库中是否已经存在相同id的用户
    @RequestMapping("/checkIdWhetherExist")
    @ResponseBody
    public user checkIdWhetherExits(@RequestParam(value = "id") String id){
        System.out.println("检验用户ID是否唯一");
        System.out.println("参数为"+id);
        user u=new user(Integer.parseInt(id));
        /*user uu=userService.checkOne(u);
        String msg="后台查询失败查询失败";
        if(uu==null){
            msg= "该ID可以使用";
        }else if(uu!=null){
            msg= "该用户ID以存在";
        }
        return msg;*/
        return userService.checkOne(u);
    }

    //分页查询
    @RequestMapping("/paging")
    private String paging(@RequestParam("pageNumber") int pagenumber,
                            @RequestParam(value = "queryCondition",required = false) String queryCondition,
                          HttpServletRequest request){
        int pageSize=3;
        Paging paging=new Paging();
        if(queryCondition!=null&&queryCondition!="")
            paging.setQueryCondition(queryCondition);
        paging.setPageSize(pageSize);
        paging.setPageNumber(pagenumber);
        paging.setListCount(userService.count(paging));
        paging.setTotalPageCount(paging.getListCount()%pageSize==0? paging.getListCount()/pageSize : paging.getListCount()/pageSize+1 );
        paging.setUserList(userService.paging(paging));
        request.setAttribute("paging",paging);

        HttpSession session=request.getSession(true);
        session.setAttribute("s","aaa");

        return "paging";
    }
}
