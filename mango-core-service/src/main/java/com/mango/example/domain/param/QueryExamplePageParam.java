package com.mango.example.domain.param;

import com.bzn.util.page.PageListRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 查询示例列表请求参数
 *
 * @author whc
 * @version 1.0.0
 * @since 2020/04/21 14:39
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class QueryExamplePageParam extends PageListRequest {

    private static final long serialVersionUID = 4955260286893404979L;

    /**
     * 示例Code（精确查询）
     */
    private String exampleCode;

    /**
     * 示例名称(模糊查询)
     */
    private String exampleName;
}
