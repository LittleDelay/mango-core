package com.mango.core.enums;

import java.util.Objects;

/**
 * 身份认证
 *
 * @author xs.Liu
 * @version 1.0.0
 * @since 2021/3/5 11:38
 */
public enum IdType {

    /**
     * 未定义
     */
    UNDEFINE(0, "未定义"),

    /**
     * 微信号
     */
    WEIXIN(9, "微信号"),

    /**
     * 大陆身份证
     */
    ID_CARD(10, "大陆身份证"),

    /**
     * 港澳台身份证
     */
    HK_TW_IDCARD(11, "港澳台身份证"),

    /**
     * 学生证
     */
    STUDENT_CARD(12, "学生证"),

    /**
     * 军官证
     */
    MILITARY_ID(13, "军官证"),

    /**
     * 护照
     */
    PASSPORT(14, "护照"),

    /**
     * 名片
     */
    BIZ_CARD(15, "名片");

    private final int code;
    private final String name;

    private IdType(int code, String name) {
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
        IdType[] var1 = values();

        for (IdType status : var1) {
            if (Objects.equals(code, status.getCode())) {
                return status.getName();
            }
        }

        return "";
    }

    public static Integer getCodeByName(String name) {
        IdType[] var1 = values();

        for (IdType status : var1) {
            if (Objects.equals(name, status.getName())) {
                return status.getCode();
            }
        }

        return 0;
    }
}
