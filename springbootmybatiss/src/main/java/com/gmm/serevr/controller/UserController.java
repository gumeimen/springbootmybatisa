package com.gmm.serevr.controller;

import com.gmm.serevr.model.User;
import com.gmm.serevr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

/**
 * Created by 古美門 on 2017-07-11 09:16.
 */
@Controller
@RequestMapping("/web/user")
public class UserController {

    @Autowired
    private UserService userService;

    //列出所有用户信息;
    @RequestMapping("/list")
    public String listUser (ModelMap map){
        List<User> userList  = userService.listUser();
        map.addAttribute("users", userList);
        return "user/list";
    }

    //跳转到添加页面
    @RequestMapping("/add")
    public String addVersionPage(){
        return "user/add";
    }

    //添加用户信息;
    @RequestMapping("/add_submit")
    public String addUser (@RequestParam(value = "name",required = false) String name,
                           @RequestParam(value = "gender",required = false) String gender,
                           @RequestParam(value = "age",required = false) Integer age){
        userService.addUser(name, gender, age);
        return "redirect:list";
    }

    //删除用户信息;
    @RequestMapping("/delete")
    public String deleteUser (@RequestParam(value = "id",required = false) Integer id){
        userService.deleteUser(id);
        return "redirect:list";
    }

    //跳转到修改页面
    @RequestMapping("/edit")
    public String getUpdatePage(ModelMap map,@RequestParam(value = "id",required = false) Integer id){
        User user = userService.getUser(id);
        map.addAttribute("user",user);
        return "user/edit";
    }

    //修改用户信息;
    @RequestMapping("/edit_submit")
    public String updateUser (@RequestParam(value = "id",required = false) Integer id,
                              @RequestParam(value = "name",required = false) String name,
                              @RequestParam(value = "gender",required = false) String gender,
                              @RequestParam(value = "age",required = false) Integer age){
        userService.updateUser(id,name,gender,age);
        return "redirect:list";
    }

    //获取指定的用户信息;
    @RequestMapping("/info")
    public String getUser (ModelMap map,@RequestParam(value = "id",required = true) Integer id){
        User user = userService.getUser(id);
        map.addAttribute("user", user);
        return "user/info";
    }
}
