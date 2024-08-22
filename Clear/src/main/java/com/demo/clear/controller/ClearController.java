package com.demo.clear.controller;


import com.demo.clear.dao.ClearMapper;
import com.demo.domain.ClearLogDTO;
import com.demo.domain.FundsDTO;
import com.demo.domain.FundsValueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/tclear")
public class ClearController {
    @Autowired
    ClearMapper clearMapper;

    // 清算
    @PostMapping("/settlement")
    public Map<String, Object> settlement(
            @RequestParam(value = "answers" , required = false) Map<String, Object> answers) {
        Map<String, Object> response = new HashMap<>();
        try {
            clearMapper.selectLatestLog();
            // 执行清算逻辑...
            ClearLogDTO log = new ClearLogDTO();
            log.setLogType("清算");
            log.setLogContent("执行成功");
            //log.setTimestamp(System.currentTimeMillis());
            clearMapper.insertLog(log);
            response.put("status", 200);
            response.put("msg", "清算成功");
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "清算异常");
            System.out.println("清算异常:" + e);
        }
        return response;
    }

    // 重新清算
    @PostMapping("/reprocess")
    public Map<String, Object> reprocess(
            @RequestParam(value = "answers" , required = false) Map<String, Object> answers) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 执行重新清算逻辑...
            ClearLogDTO log = new ClearLogDTO();
            log.setLogType("重新清算");
            log.setLogContent("执行成功");
            clearMapper.insertLog(log);
            response.put("status", 200);
            response.put("msg", "重新清算成功");
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "重新清算异常");
            System.out.println("重新清算异常:" + e);
        }
        return response;
    }
    // 根据时间戳查询清算日志
    @GetMapping("/select")
    public Map<String, Object> select(
            @RequestParam("timestamp") Long timestamp){

        System.out.println("--------------select--------------");
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            // 构造模糊查询的模式字符串
            String pattern = String.format("%d%%", timestamp);
            List<ClearLogDTO> logsList = clearMapper.selectLogsByPattern(pattern);
            List<Map<String, Object>> formattedLogsList = new ArrayList<>(); // 创建一个新列表来存储格式化后的数据
            // 检查查询结果并构建响应
            if (logsList != null) {
                for (ClearLogDTO logDTO : logsList) {
                    // 将timestamp转换为Date对象
                    long date = logDTO.getTimestamp();
                    //System.out.println(logDTO.getTimestamp()+"----"+logDTO.getLogContent());
                    // 将long型的时间戳转换为String类型
                    String timestampStr = String.valueOf(date);
                    String formattedTime="18:00:00";
                    // 确保时间戳的长度为14位，然后提取最后6位
                    if (timestampStr.length() == 14) {
                        // 提取最后6位，即时分秒部分
                        String timePart = timestampStr.substring(8, 14);
                        // 格式化为"时：分：秒"格式
                        formattedTime = timePart.substring(0, 2) + ":" +
                                timePart.substring(2, 4) + ":" +
                                timePart.substring(4, 6);
                        // 打印或使用formattedTime
                        //System.out.println(formattedTime);
                    } else {
                        // 如果时间戳长度不是14位，打印错误或进行其他错误处理
                        System.out.println("Invalid timestamp length");
                    }

                    // 创建包含日志信息和时间的Map
                    Map<String, Object> logEntry = new HashMap<>();
                    logEntry.put("log_type", logDTO.getLogType());
                    logEntry.put("log_content", logDTO.getLogContent());
                    logEntry.put("log_time", formattedTime); // 添加格式化后的时间

                    // 将Map添加到列表中
                    formattedLogsList.add(logEntry);
                }

                // 将结果列表放入data中
                data.put("logsList", formattedLogsList);
                response.put("status", 200);
                response.put("msg", "查询成功");
                response.put("data", data);
            } else {
                response.put("status", 400);
                response.put("msg", "未找到对应的日志");
            }
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "查询异常");
            response.put("data", null);
            System.out.println("查询异常:" + e);
        }
        return response;
    }
}
