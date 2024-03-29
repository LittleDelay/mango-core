package com.mango.core.exception;

/**
 * 异常处理
 *
 * @author xs.Liu
 * @version 1.0.0
 * @since 2021/6/29 12:32
 */
public class BizException extends RuntimeException {

    private String msg;

    private int code;

    public BizException(int code, String msg) {
        super(code + ":" + msg, null, true, true);
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
