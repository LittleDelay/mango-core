package com.mango.core.bean.response;

/**
 * 失败操作返回的数据模型定义
 *
 * @author xs.Liu
 * @version 1.0.0
 * @since 2021/3/5 11:21
 */
public class ErrorResponseData extends ApiResponse {

    public ErrorResponseData(Integer code, String message) {
        super(false, code, message, null);
    }

    public ErrorResponseData(Integer code, String message, Object object) {
        super(false, code, message, object);
    }

}
