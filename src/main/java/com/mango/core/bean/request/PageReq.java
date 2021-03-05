package com.mango.core.bean.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 分页请求参数
 *
 * @author xs.Liu
 * @version 1.0.0
 * @since 2021/3/5 10:46
 */
@Data
public class PageReq implements Serializable {

    private static final long serialVersionUID = 1424203553843031618L;

    /**
     * 当前页
     */
    @ApiModelProperty("当前页，默认第一页")
    private Integer pageNum;

    /**
     * 每页显示条数
     */
    @ApiModelProperty("每页显示条数，默认15条")
    private Integer pageSize;

    public Integer getPageNum() {
        return this.pageNum != null && this.pageNum >= 1 ? this.pageNum : 1;
    }

    public Integer getPageSize() {
        return this.pageSize != null && this.pageSize >= 1 ? this.pageSize : 15;
    }
}
