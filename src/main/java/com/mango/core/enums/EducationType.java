package com.mango.core.enums;

import java.util.Objects;

/**
 * 学历信息
 *
 * @author xs.Liu
 * @version 1.0.0
 * @since 2021/3/5 11:45
 */
public enum EducationType {

    /**
     * 未定义
     */
    UNDEFINE(0, "未定义"),

    /**
     * 初中
     */
    MIDDLE(1, "初中"),

    /**
     * 高中
     */
    HIGH(2, "高中"),

    /**
     * 中专
     */
    TECHNICAL(3, "中专"),

    /**
     * 大专
     */
    COLLEGE(4, "大专"),

    /**
     * 本科
     */
    BACHELOR(5, "本科"),

    /**
     * 硕士
     */
    MASTER(6, "硕士"),

    /**
     * MBA
     */
    MBA(7, "MBA"),

    /**
     * EMBA
     */
    EMBA(8, "EMBA"),

    /**
     * 博士
     */
    PHD(9, "博士");

    private final int code;
    private final String name;

    private EducationType(int code, String name) {
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
        EducationType[] var1 = values();

        for (EducationType status : var1) {
            if (Objects.equals(code, status.getCode())) {
                return status.getName();
            }
        }

        return "";
    }

    public static Integer getCodeByName(String name) {
        EducationType[] var1 = values();

        for (EducationType status : var1) {
            if (Objects.equals(name, status.getName())) {
                return status.getCode();
            }
        }

        return 0;
    }
}
