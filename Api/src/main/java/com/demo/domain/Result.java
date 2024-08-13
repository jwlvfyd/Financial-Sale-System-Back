package com.demo.domain;

import lombok.Data;

/**
 * 数据返回
 */
@Data
public class Result {
    private Integer status;
    private String msg;
    private Object data;
    public Result(){

    }
    public Result(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
