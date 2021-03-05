package com.mango.core.bean.response;

/**
 * Api返回结果
 *
 * @author xs.Liu
 * @version 1.0.0
 * @since 2021/3/5 11:19
 */
public class ApiResponse<T> {

    /**
     * 执行成功
     */
    public static final Integer OK = 200;

    /**
     * 内部异常
     */
    public static final Integer INNER_ERROR = 500;

    /**
     * 操作成功返回信息
     */
    public static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";

    /**
     * 操作状态：是否成功
     */
    private Boolean success;

    /**
     * 操作码
     */
    private Integer code;

    /**
     * 返回操作消息
     */
    private String msg;

    /**
     * 返回数
     */
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(Boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public void setData(T data) {
        this.data = data;
    }

}
