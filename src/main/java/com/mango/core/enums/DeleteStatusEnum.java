package com.mango.core.enums;

import java.util.Objects;

/**
 * 删除状态
 *
 * @author xs.Liu
 * @version 1.0.0
 * @since 2021/10/9 11:15
 */
public enum DeleteStatusEnum {

    /**
     * 已删除
     */
    MALE(0, "已删除"),

    /**
     * 未删除
     */
    FEMALE(1, "未删除");

    private final int code;
    private final String name;

    private DeleteStatusEnum(int code, String name) {
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
        DeleteStatusEnum[] var1 = values();

        for (DeleteStatusEnum status : var1) {
            if (Objects.equals(code, status.getCode())) {
                return status.getName();
            }
        }

        return "";
    }

    public static Integer getCodeByName(String name) {
        DeleteStatusEnum[] var1 = values();

        for (DeleteStatusEnum status : var1) {
            if (Objects.equals(name, status.getName())) {
                return status.getCode();
            }
        }

        return 0;
    }
}
