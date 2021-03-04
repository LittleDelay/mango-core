package com.mango.api.example.domain.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 添加示例响应结果
 *
 * @author whc
 * @version 1.0.0
 * @since 2020/04/21 14:53
 */
@Data
@Accessors(chain = true)
public class AddExampleResponse implements Serializable {

    private static final long serialVersionUID = 488205673032086981L;

    /**
     * 示例ID
     */
    private Long id;
    
}
