package com.demo.product.dao;

import com.demo.domain.FundsDTO;
import com.demo.domain.FundsValueDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    @Insert("INSERT INTO tfunds (product_id, product_name, product_type, risk_level, product_state, create_time) " +
            "VALUES (#{productId}, #{productName}, #{productType}, #{riskLevel}, #{productState}, NOW())")
    int addProductDTO(@Param("productId") String productId,
                      @Param("productName") String productName,
                      @Param("productType") String productType,
                      @Param("riskLevel") int riskLevel,
                      @Param("productState") String productState);

    @Select("SELECT product_id AS productId, product_name AS productName, product_type AS productType, " +
            "risk_level AS riskLevel, product_state AS productState, create_time AS createTime " +
            "FROM tfunds " +
            "WHERE product_id LIKE CONCAT('%', #{productId}, '%') " +
            "AND product_name LIKE CONCAT('%', #{productName}, '%') " +
            "AND product_type LIKE CONCAT('%', #{productType}, '%') " +
            "AND (#{riskLevel} = 0 OR risk_level = #{riskLevel}) " +
            "AND product_state LIKE CONCAT('%', #{productState}, '%')")
    List<FundsDTO> selectProductDTO(@Param("productId") String productId,
                                    @Param("productName") String productName,
                                    @Param("productType") String productType,
                                    @Param("riskLevel") int riskLevel,
                                    @Param("productState") String productState);


    @Select("SELECT product_id AS productId, product_name AS productName, product_type AS productType, " +
            "risk_level AS riskLevel, product_state AS productState, create_time AS createTime " +
            "FROM tfunds " +
            "WHERE product_id=#{productId}")
    FundsDTO queryProductDTO(@Param("productId") String productId);

    @Select("SELECT * " +
            "FROM tfundsvalue ")
    List<FundsValueDTO> queryFundsValueDTO();
}
