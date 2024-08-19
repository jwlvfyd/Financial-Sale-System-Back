package com.demo.trade.dao;

import com.demo.domain.PurchaseDTO;
import org.apache.ibatis.annotations.*;
import java.math.BigDecimal;
import java.util.List;


public interface TradeMapper {

    // 申购操作
    @Insert("INSERT INTO tpurchase (account_id, money, product_id, customer_id, swift_no, timestamp) "
            + "VALUES (#{accountId}, #{money}, #{productId}, #{customerId}, #{swift}, 1111111111111)")
    int subscribe(
            @Param("accountId") String accountId,
            @Param("money") BigDecimal money,
            @Param("productId") String productId,
            @Param("customerId") String customerId,
            @Param("swift") String swift);

    // 赎回操作
    @Insert("INSERT INTO tredeem (account_id, share, product_id, customer_id, swift_no, timestamp) "
            + "VALUES (#{accountId}, #{share}, #{productId}, #{customerId}, #{swift}, 1111111111111)")
    boolean redeem(
            @Param("accountId") String accountId,
            @Param("share") BigDecimal share,
            @Param("productId") String productId,
            @Param("customerId") String customerId,
            @Param("swift") String swift);

    // 撤单操作
    @Delete("DELETE FROM tpurchase WHERE swift_no = #{swiftNo}")
    boolean cancelOrder(
            @Param("swiftNo") String swiftNo);
}