package com.mango.core.enums;

import java.util.Objects;

/**
 * 文件类型
 *
 * @author xs.Liu
 * @version 1.0.0
 * @since 2021/3/5 11:44
 */
public enum FileTypeEnum {

    /**
     * 图片类
     */
    JPG(1, "jpg"),
    BMP(1, "bmp"),
    JPEG(1, "jpeg"),
    PNG(1, "png"),

    /**
     * 文档类
     */
    TXT(2, "txt"),
    DOC(2, "doc"),
    DOCX(2, "docx"),
    XLS(2, "xls"),
    PDF(2, "pdf"),
    PPT(2, "ppt"),

    /**
     * 视频类
     */
    MP4(3, "mp4"),
    AVI(3, "avi"),
    MOV(3, "mov"),
    WMV(3, "wmv"),
    WEBM(3, "webm"),
    RMVB(3, "rmvb"),

    /**
     * 音频类
     */
    MP3(4, "mp3");

    private final int code;
    private final String name;

    private FileTypeEnum(int code, String name) {
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
        FileTypeEnum[] var1 = values();

        for (FileTypeEnum status : var1) {
            if (Objects.equals(code, status.getCode())) {
                return status.getName();
            }
        }

        return "";
    }

    public static Integer getCodeByName(String name) {
        FileTypeEnum[] var1 = values();

        for (FileTypeEnum status : var1) {
            if (Objects.equals(name, status.getName())) {
                return status.getCode();
            }
        }

        return 0;
    }

}
