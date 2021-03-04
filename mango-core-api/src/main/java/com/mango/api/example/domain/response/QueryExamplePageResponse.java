package com.mango.api.example.domain.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 查询示例列表响应结果
 *
 * @author Shangxp
 * @version 1.0.0
 * @since 2020/4/20 21:01
 */
@Data
@Accessors(chain = true)
public class QueryExamplePageResponse implements Serializable {

    private static final long serialVersionUID = -7774702072801295259L;

    /**
     * 示例ID
     */
    private Long exampleId;

    /**
     * 示例Code
     */
    private String exampleCode;

    /**
     * 示例名称
     */
    private String exampleName;

}
