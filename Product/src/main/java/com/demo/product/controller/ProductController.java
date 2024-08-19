package com.demo.product.controller;

import com.demo.domain.FundsDTO;
import com.demo.domain.FundsValueDTO;
import com.demo.domain.UserDTO;
import com.demo.product.dao.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tproduct")
public class ProductController {
    @Autowired
    ProductMapper productMapper;
    @PostMapping("/add")
    public Map<String, Object> add(
            @RequestParam(value = "productId") String productId,
            @RequestParam(value = "productName") String productName,
            @RequestParam(value = "productType") String productType,
            @RequestParam(value = "riskLevel", defaultValue = "1") int riskLevel,
            @RequestParam(value = "productState", defaultValue = "normal") String productState) {

        System.out.println("--------------add--------------");
        Map<String, Object> response = new HashMap<>();
        try {

            int result = productMapper.addProductDTO(productId, productName, productType, riskLevel, productState);
            System.out.println("Insert result: " + result);
            if (result ==1) {
                response.put("status", 200);
                response.put("msg", "插入成功");
                response.put("data", null);
            } else {
                response.put("status", 400);
                response.put("msg", "插入失败");
                response.put("data", null);
            }
            return response;
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "插入异常");
            response.put("data", null);
            System.out.println("插入异常:" + e);
            return response;
        }
    }

    @GetMapping("/select")
    public Map<String, Object> select(
            @RequestParam(value = "productId", defaultValue = "%") String productId,
            @RequestParam(value = "productName", defaultValue = "%") String productName,
            @RequestParam(value = "productType", defaultValue = "%") String productType,
            @RequestParam(value = "riskLevel", defaultValue = "0") int riskLevel,
            @RequestParam(value = "productState", defaultValue = "%") String productState) {

        System.out.println("--------------select--------------");
        Map<String, Object> response = new HashMap<>();
        try {
            List<FundsDTO> Funds = productMapper.selectProductDTO(productId, productName, productType, riskLevel, productState);
            response.put("status", 200);
            response.put("msg", "查询成功");
            response.put("data", Funds);
            System.out.println("Select successfully!");
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "查询异常");
            response.put("data", null);
            System.out.println("查询异常:" + e);
        }
        return response;
    }


    @GetMapping("/query")
    public Map<String, Object> query(
            @RequestParam(value = "productId") String productId){

        System.out.println("--------------query--------------");
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            FundsDTO Funds = productMapper.queryProductDTO(productId);
            List<FundsValueDTO> values = productMapper.queryFundsValueDTO();
            response.put("status", 200);
            response.put("msg", "查询成功");
            data.put("productId",Funds.getProductId());
            data.put("productName",Funds.getProductName());
            data.put("productType",Funds.getProductType());
            data.put("riskLevel",Funds.getRiskLevel());
            data.put("productState",Funds.getProductState());
            data.put("createTime",Funds.getCreateTime());
            data.put("values",values);
            response.put("data", data);
            System.out.println("Query successfully!");
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "查询异常");
            response.put("data", null);
            System.out.println("查询异常:" + e);
        }
        return response;
    }

}
