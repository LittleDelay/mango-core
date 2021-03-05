package com.mango.core.enums;

import java.util.Objects;

/**
 * 性别
 *
 * @author xs.Liu
 * @version 1.0.0
 * @since 2021/3/5 11:42
 */
public enum GenderEnum {

    /**
     * 男
     */
    MALE(1, "男"),

    /**
     * 女
     */
    FEMALE(2, "女");

    private final int code;
    private final String name;

    private GenderEnum(int code, String name) {
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
        GenderEnum[] var1 = values();

        for (GenderEnum status : var1) {
            if (Objects.equals(code, status.getCode())) {
                return status.getName();
            }
        }

        return "";
    }

    public static Integer getCodeByName(String name) {
        GenderEnum[] var1 = values();

        for (GenderEnum status : var1) {
            if (Objects.equals(name, status.getName())) {
                return status.getCode();
            }
        }

        return 0;
    }

}
