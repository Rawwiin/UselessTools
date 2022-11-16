package com.example.uselesstools.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Rawwiin
 */
@Data
@AllArgsConstructor
public class Result<T> {
    String msg;


    Integer code;

    T data;

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

}
