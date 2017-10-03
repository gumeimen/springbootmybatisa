package com.gmm.serevr.service;

import com.gmm.serevr.mapper.UserMapper;
import com.gmm.serevr.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 古美門 on 2017-07-11 09:17.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 列出所有用户列表信息;
     * @return
     */
    public List<User> listUser(){
        List<User> userList = userMapper.findAll();
        return userList;
    }

    /**
     * 添加用户信息
     * @param name
     * @param gender
     * @param age
     * @return
     */
    public User addUser(String name, String gender, Integer age){
        User user = new User();
        user.setName(name);
        user.setGender(gender);
        user.setAge(age);
        userMapper.addUser(user);
        return user;
    }

    /**
     * 删除用户信息;
     * @param id
     */
    public Boolean deleteUser(Integer id) {
        int number = userMapper.deleteuser(id);
        if (number>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 修改指定用户;
     * @param id
     * @param name
     * @param gender
     * @param age
     * @return
     */
    public Boolean updateUser(Integer id,String name,String gender,Integer age) {
        if (id!=null){
            User user1 = userMapper.findUserById(id);
            if (user1!=null){
                User user = new User();
                user.setName(name);
                user.setGender(gender);
                user.setAge(age);
                user.setId(id);
                userMapper.updateUser(user);
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * 获取指定的学生信息;
     * @param id
     */
    public User getUser(Integer id) {
        User user = userMapper.findUserById(id);
        return user;

    }

}
