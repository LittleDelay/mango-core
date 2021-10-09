package com.mango.core.enums;

import java.util.Objects;

/**
 * 等级信息
 *
 * @author xs.Liu
 * @version 1.0.0
 * @since 2021/10/9 11:24
 */
public enum LvEnum {

    /**
     * 等级
     */
    LV1(1, "LV1"),
    LV2(2, "LV2"),
    LV3(3, "LV3"),
    LV4(4, "LV4"),
    LV5(5, "LV5"),
    LV6(6, "LV6"),
    LV7(7, "LV7"),
    LV8(8, "LV8"),
    LV9(9, "LV9"),
    LV10(10, "LV10"),
    LV11(11, "LV11"),
    LV12(12, "LV12");

    private final int code;
    private final String name;

    private LvEnum(int code, String name) {
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
        LvEnum[] var1 = values();

        for (LvEnum status : var1) {
            if (Objects.equals(code, status.getCode())) {
                return status.getName();
            }
        }

        return "";
    }

    public static Integer getCodeByName(String name) {
        LvEnum[] var1 = values();

        for (LvEnum status : var1) {
            if (Objects.equals(name, status.getName())) {
                return status.getCode();
            }
        }

        return 0;
    }

}
