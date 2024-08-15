package com.demo.customer.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    @Insert("INSERT INTO taccount (customer_id, account_id, bank_name, balance) " +
            "VALUES (#{customerId}, #{accountId}, #{bankName}, 0)")
    int addCardDTO(@Param("customerId") String customerId,
                      @Param("accountId") String accountId,
                      @Param("bankName") String bankName);

    @Insert("UPDATE taccount " +
            "SET balance = #{amount} " +
            "WHERE customer_id = #{customerId} "+
            "AND account_id = #{accountId}"
    )
    int accountChangedDTO(@Param("customerId") String customerId,
                   @Param("accountId") String accountId,
                   @Param("amount") String amount);
}
