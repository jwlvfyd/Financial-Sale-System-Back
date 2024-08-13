package com.demo.customer.dao;

import com.demo.domain.UserDTO;
import org.apache.ibatis.annotations.Select;

public interface TestMapper {
    @Select("select * from tuser where name = #{name}")
    UserDTO testUserDTO(String name);
}
