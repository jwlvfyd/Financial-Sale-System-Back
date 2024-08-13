package com.demo.service.dao;

import com.demo.domain.TestUserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestMapper {
    @Insert("insert into test.test_user(user_id, user_name, address) values (#{user.userId}, #{user.userName}, #{user.address})")
    int createUser(@Param("user") TestUserDTO user);
}
