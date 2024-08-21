package com.demo.trade.dao;

import com.demo.domain.PurchaseDTO;
import org.apache.ibatis.annotations.*;
import java.math.BigDecimal;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



public interface TradeMapper {

    // 申购操作
    @Insert("INSERT INTO tpurchase (account_id, money, product_id, customer_id, swift_no, state, timestamp) "
            + "VALUES (#{accountId}, #{money}, #{productId}, #{customerId}, #{swiftNo}, '\"正常\"', NOW())")
    int subscribe(
            @Param("accountId") String accountId,
            @Param("money") BigDecimal money,
            @Param("productId") String productId,
            @Param("customerId") String customerId,
            @Param("swiftNo") String swiftNo
            );
    @Select("SELECT balance FROM taccount WHERE account_id = #{accountId} AND customer_id = #{customerId}")
    BigDecimal getAccountBalance(
            @Param("accountId") String accountId,
            @Param("customerId") String customerId);

    // 赎回操作
    @Insert("INSERT INTO tredeem (account_id, share, product_id, customer_id, swift_no, state, timestamp) "
            + "VALUES (#{accountId}, #{share}, #{productId}, #{customerId}, #{swiftNo}, '\"正常\"', NOW())")
    int redeem(
            @Param("accountId") String accountId,
            @Param("share") BigDecimal share,
            @Param("productId") String productId,
            @Param("customerId") String customerId,
            @Param("swiftNo") String swiftNo
    );
    // TradeMapper.java 中添加新的方法 getAllMoneyForRedeem
    @Select("SELECT IFNULL(SUM(money), 0) FROM tpurchase WHERE account_id = #{accountId} AND product_id = #{productId} AND customer_id = #{customerId}")
    BigDecimal getAllMoneyForRedeem(
            @Param("accountId") String accountId,
            @Param("productId") String productId,
            @Param("customerId") String customerId);

    // 查询当天最大序列号的后五位sub
    @Select("SELECT LPAD(MAX(CAST(SUBSTRING(swift_no FROM -5) AS UNSIGNED)), 5, '0') FROM tpurchase WHERE DATE(timestamp) = DATE(NOW())")
    String getsubMaxSequenceForDate();
    // 查询当天最大序列号的后五位red
    @Select("SELECT LPAD(MAX(CAST(SUBSTRING(swift_no FROM -5) AS UNSIGNED)), 5, '0') FROM tredeem WHERE DATE(timestamp) = DATE(NOW())")
    String getredMaxSequenceForDate();

    // 辅助方法，用于生成swift_no
    default String generateSwiftNo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String datePart = dateFormat.format(new Date());
        String maxSequenceStr1 = getsubMaxSequenceForDate();
        String maxSequenceStr2 = getredMaxSequenceForDate();
        int maxSequence1 = Integer.parseInt(maxSequenceStr1);
        int maxSequence2 = Integer.parseInt(maxSequenceStr2);
        String maxSequenceStr;
        if(maxSequence1>=maxSequence2)
            maxSequenceStr="" + maxSequence1;
        else
            maxSequenceStr="" + maxSequence2;
        if ((maxSequenceStr1 == null&& maxSequenceStr2 == null)|| (maxSequenceStr1.isEmpty()&&maxSequenceStr2.isEmpty())) {
            // 如果当天没有记录，从00001开始
            return datePart + "00001";
        } else {
            // 将字符串转换为整数并加一
            int maxSequence = Integer.parseInt(maxSequenceStr);
            int nextSequence = maxSequence + 1;
            // 将新的序列号转换为五位数的字符串
            String sequencePart = String.format("%05d", nextSequence);
            return datePart + sequencePart;
        }
    }


    // 撤单操作
    // 检查 tpurchase 表中是否存在指定的 swiftNo
    @Select("SELECT COUNT(*) FROM tpurchase WHERE swift_no = #{swiftNo}")
    int checkPurchaseExist(@Param("swiftNo") String swiftNo);

    // 检查 tredeem 表中是否存在指定的 swiftNo
    @Select("SELECT COUNT(*) FROM tredeem WHERE swift_no = #{swiftNo}")
    int checkRedeemExist(@Param("swiftNo") String swiftNo);

    // 更新对应表的 state 为 “撤单”
    @Update("UPDATE tpurchase SET state = '撤单' WHERE swift_no = #{swiftNo}")
    int updatePurchaseState(@Param("swiftNo") String swiftNo);

    @Update("UPDATE tredeem SET state = '撤单' WHERE swift_no = #{swiftNo}")
    int updateRedeemState(@Param("swiftNo") String swiftNo);

    // 插入撤单记录到 tcancellation 表
    @Insert("INSERT INTO tcancellation (swift_no) VALUES (#{swiftNo})")
    int logCancellation(@Param("swiftNo") String swiftNo);

}