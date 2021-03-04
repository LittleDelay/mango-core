package com.mango.api.example.domain.request;

import com.bzn.util.param.ParamRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 查询示例集合请求参数
 *
 * @author whc
 * @version 1.0.0
 * @since 2020/04/22 16:29
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class QueryExampleListRequest extends ParamRequest {

    /**
     * 示例Code（精确查询）
     */
    private String exampleCode;

    /**
     * 示例名称（模糊查询）
     */
    private String exampleName;
}
