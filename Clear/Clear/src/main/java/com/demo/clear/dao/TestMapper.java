package com.demo.clear.dao;

import com.demo.domain.UserDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestMapper {
    @Select("select * from tuser where name = #{name}")
    UserDTO testUserDTO(String name);
}
