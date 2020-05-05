package com.g2academy.mybatis.springbootmybatis.mapper;

import com.g2academy.mybatis.springbootmybatis.model.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Select("select * from student")
    List<Users> findAll();

    @Insert("insert into student(NAME,BRANCH,PERCENTAGE,PHONE,EMAIL) values (#{name},#{branch},#{percentage},#{phone},#{email})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",before = false,resultType = Integer.class)
    void insert(Users users);

    @Update("update student set NAME=#{name},BRANCH=#{branch},PERCENTAGE=#{percentage},PHONE=#{phone},EMAIL=#{email} where ID=#{id}")
    void update(Users users);

    @Delete("delete from student where ID=#{id}")
    void delete(int id);
}
