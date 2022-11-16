package com.example.uselesstools.model.request;

public enum ResultCode {
    SUCCESS(0, "操作成功"),
    ERROR(-1, "未知错误"),
    ERROR_PARAM(-2, "参数错误"),
    ERROR_DATABASE(-3, "数据库错误"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    CUSTOM(-999,"自定义消息");
    private int code;
    private String msg;

    private ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result createResult() {
        return createResult(null);
    }

    public Result createResult(Object data) {
        return new Result(getMsg(), getCode(), data);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}