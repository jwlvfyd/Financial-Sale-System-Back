package com.demo.trade.dao;

import com.demo.domain.PurchaseDTO;
import org.apache.ibatis.annotations.*;
import java.math.BigDecimal;
import java.util.List;


public interface TradeMapper {

    // 申购操作
    @Insert("INSERT INTO tpurchase (account_id, money, product_id, customer_id, swift_no, timestamp) "
            + "VALUES (#{accountId}, #{money}, #{productId}, #{customerId}, 10, NOW())")
    int subscribe(
            @Param("accountId") String accountId,
            @Param("money") BigDecimal money,
            @Param("productId") String productId,
            @Param("customerId") String customerId
    );
    @Select("SELECT swift_no " +
            "FROM tpurchase " +
            "WHERE account_id = #{accountId} " +
            "AND money = #{money} " +
            "AND product_id = #{productId} " +
            "AND customer_id = #{customerId}"+
            "ORDER BY timestamp DESC " +
            "LIMIT 1")
    String selectsubSwiftNo(
            @Param("accountId") String accountId,
            @Param("money") BigDecimal money,
            @Param("productId") String productId,
            @Param("customerId") String customerId);

    // 赎回操作
    @Insert("INSERT INTO tredeem (account_id, share, product_id, customer_id, swift_no, timestamp) "
            + "VALUES (#{accountId}, #{share}, #{productId}, #{customerId}, 10, NOW())")
    int redeem(
            @Param("accountId") String accountId,
            @Param("share") BigDecimal share,
            @Param("productId") String productId,
            @Param("customerId") String customerId
    );
    @Select("SELECT swift_no " +
            "FROM tredeem " +
            "WHERE account_id = #{accountId} " +
            "AND share = #{share} " +
            "AND product_id = #{productId} " +
            "AND customer_id = #{customerId}"+
            "ORDER BY timestamp DESC " +
            "LIMIT 1")
    String selectreSwiftNo(
            @Param("accountId") String accountId,
            @Param("share") BigDecimal share,
            @Param("productId") String productId,
            @Param("customerId") String customerId);

    // 撤单操作
    @Delete("DELETE FROM tpurchase WHERE swift_no = #{swiftNo}")
    boolean cancelOrder(
            @Param("swiftNo") String swiftNo);


}