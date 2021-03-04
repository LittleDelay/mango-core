package com.mango.api.example.domain.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 查询示例集合响应结果
 *
 * @author whc
 * @version 1.0.0
 * @since 2020/04/22 16:30
 */
@Data
@Accessors(chain = true)
public class QueryExampleListResponse implements Serializable {

    private static final long serialVersionUID = -5144855759747375588L;

    /**
     * 示例集合
     */
    private List<Example> examples;

    /**
     * 示例信息
     */
    @Data
    public static class Example implements Serializable {

        private static final long serialVersionUID = -3345024686985527952L;

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
}
