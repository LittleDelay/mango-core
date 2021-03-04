package com.mango.example.domain.param;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 查询示例集合请求参数
 *
 * @author whc
 * @version 1.0.0
 * @since 2020/04/21 14:39
 */
@Data
@Accessors(chain = true)
public class QueryExampleListParam implements Serializable {

    private static final long serialVersionUID = -8098786210974622116L;

    /**
     * 示例Code（精确查询）
     */
    private String exampleCode;

    /**
     * 示例名称(模糊查询)
     */
    private String exampleName;
}
