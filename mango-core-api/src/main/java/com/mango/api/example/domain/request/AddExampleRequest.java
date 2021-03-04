package com.mango.api.example.domain.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 添加示例请求参数
 *
 * @author whc
 * @version 1.0.0
 * @since 2020/04/21 14:52
 */
@Data
@Accessors(chain = true)
public class AddExampleRequest implements Serializable {

    private static final long serialVersionUID = -1702966954823527016L;

    /**
     * 示例名称
     */
    private String exampleName;
    
}
