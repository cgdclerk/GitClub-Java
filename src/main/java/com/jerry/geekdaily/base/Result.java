package com.jerry.geekdaily.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

// 字段排序输出
@JSONType(orders={"code","msg","data"})
public class Result<T> implements Serializable {

    private int code;//状态码(0成功  1失败)

    private String msg;//返回信息

    private Object data;//数据

    //必须要有空构造函数  不然redis会报错
    public Result() {
    }

    //成功时调用
    public Result(T data){
        this.code = 0;
        this.msg = "OK";
        this.data = data;
    }

    //失败时调用
    public Result(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
