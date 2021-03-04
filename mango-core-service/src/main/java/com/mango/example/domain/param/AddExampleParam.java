package com.mango.example.domain.param;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 添加示例请求参数
 *
 * @author whc
 * @version 1.0.0
 * @since 2020/04/21 15:29
 */
@Data
@Accessors(chain = true)
public class AddExampleParam implements Serializable {

    private static final long serialVersionUID = 3617688638438551039L;

    /**
     * 示例名称
     */
    private String exampleName;
}
