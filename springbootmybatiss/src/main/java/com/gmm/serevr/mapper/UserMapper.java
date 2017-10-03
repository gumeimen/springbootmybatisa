package com.gmm.serevr.mapper;

import com.gmm.serevr.model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * Created by 古美門 on 2017-07-10 16:43.
 */
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(NAME,gender,age) VALUES (#{name},#{gender},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int addUser(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteuser(Integer id);

    @Update("UPDATE user SET NAME = #{name},gender=#{gender},age=#{age} WHERE id = #{id}")
    int updateUser(User user);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findUserById(Integer id);

    @Select("SELECT * FROM user")
    List<User> findAll();
}
