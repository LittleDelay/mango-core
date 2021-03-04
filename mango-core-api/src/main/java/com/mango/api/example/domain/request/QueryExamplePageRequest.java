package com.mango.api.example.domain.request;

import com.bzn.util.page.PageListParamRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 查询示例列表请求参数
 *
 * @author whc
 * @version 1.0.0
 * @since 2020/04/21 14:33
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class QueryExamplePageRequest extends PageListParamRequest {

    private static final long serialVersionUID = 3747695803170477201L;

    /**
     * 示例Code（精确查询）
     */
    private String exampleCode;

    /**
     * 示例名称（模糊查询）
     */
    private String exampleName;

}
