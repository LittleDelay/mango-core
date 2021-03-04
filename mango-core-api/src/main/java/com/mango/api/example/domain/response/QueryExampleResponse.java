package com.mango.api.example.domain.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 查询示例响应结果
 *
 * @author Shangxp
 * @version 1.0.0
 * @since 2020/4/20 21:01
 */
@Data
@Accessors(chain = true)
public class QueryExampleResponse implements Serializable {

    private static final long serialVersionUID = 1906176906652702485L;

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
