package com.mango.core.enums;

import java.util.Objects;

/**
 * 请求来源
 *
 * @author xs.Liu
 * @version 1.0.0
 * @since 2021/3/5 11:30
 */
public enum SourceEnum {

    /**
     * 网站
     */
    WEB(1, "网站"),

    /**
     * 微信
     */
    WECHAT(2, "微信"),

    /**
     * QQ
     */
    QQ(3, "QQ"),

    /**
     * 微博
     */
    WEIBO(4, "微博"),

    /**
     * 苹果手机应用
     */
    IOS_PHONE(91, "苹果手机应用"),

    /**
     * 苹果平板应用
     */
    IOS_PAD(92, "苹果平板应用"),

    /**
     * ANDROID手机应用
     */
    ANDROID_PHONE(93, "ANDROID手机应用"),

    /**
     * ANDROID平板应用
     */
    ANDROID_PAD(94, "ANDROID平板应用"),

    /**
     * 运营后台
     */
    BOSS(-1, "运营后台");

    private final int code;
    private final String name;

    private SourceEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
    public static String getNameByCode(Integer code) {
        SourceEnum[] var1 = values();

        for (SourceEnum status : var1) {
            if (Objects.equals(code, status.getCode())) {
                return status.getName();
            }
        }

        return "";
    }

    public static Integer getCodeByName(String name) {
        SourceEnum[] var1 = values();

        for (SourceEnum status : var1) {
            if (Objects.equals(name, status.getName())) {
                return status.getCode();
            }
        }

        return 0;
    }

}
