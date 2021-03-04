package com.mango.api.example.domain.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 修改示例请求参数
 *
 * @author whc
 * @version 1.0.0
 * @since 2020/04/21 15:35
 */
@Data
@Accessors(chain = true)
public class ModifyExampleRequest implements Serializable {

    private static final long serialVersionUID = -4518943906627095163L;

    /**
     * 示例名称
     */
    private String exampleName;
    
}
