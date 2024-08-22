package com.demo.customer.dao;

import com.demo.domain.AccountDTO;
import com.demo.domain.CustomerInfoDTO;
import com.demo.domain.FundsDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CustomerInfoMapper {
    @Insert("INSERT INTO tcustomerinfo (customer_id,name,gender,contact_info,risk_level) " +
            "VALUES (#{customerId},#{name}, #{gender}, #{contactInfo}, #{riskLevel})")
    int addCustomerInfoDTO(@Param("customerId") String customerId,
                           @Param("name") String name,
                           @Param("gender") String gender,
                           @Param("contactInfo") String contactInfo,
                           @Param("riskLevel") int riskLevel
    );

    @Select("SELECT customer_id AS customerId, name, gender, " +
            "contact_info AS contactInfo, risk_level AS riskLevel " +
            "FROM tcustomerinfo " +
            "WHERE customer_id LIKE CONCAT('%', #{customerId}, '%') " +
            "AND name LIKE CONCAT('%', #{name}, '%') ")
    List<CustomerInfoDTO> selectcustomerInfoDTO(@Param("customerId") String customerId,
                                                @Param("name") String name);

    @Select("SELECT customer_id AS customerId, account_id AS accountId, bank_name AS bankName, balance " +
            "FROM taccount " +
            "WHERE customer_id = #{customerId} ")
    List<AccountDTO> querycustomerInfoDTO(@Param("customerId") String customerId);


    @Update("UPDATE tcustomerinfo SET risk_level = #{riskLevel} WHERE customer_id = #{customerId}")
    int updateRiskLevel(@Param("customerId") String customerId, @Param("riskLevel") int riskLevel);

}
