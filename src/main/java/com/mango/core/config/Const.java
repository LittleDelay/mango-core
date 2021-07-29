package com.mango.core.config;

import java.io.Serializable;

/**
 * 常量配置
 *
 * @author xs.Liu
 * @version 1.0.0
 * @since 2021/6/28 16:41
 */
public class Const implements Serializable {

    /**
     * 业务token在header中的名称
     */
    public static final String TOKEN_NAME = "Admin-Token";

    /**
     * 批量保存的条数
     */
    public static final int BATCH_SAVE_SIZE = 200;

}
