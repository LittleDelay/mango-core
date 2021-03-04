package com.mango.common.service;

/**
 * ID生成接口
 *
 * @author Shangxp
 * @version 1.0.0
 * @since 2020/4/20 16:47
 */
public interface IdGenerationService {

    /**
     * 保单号生成对应列名
     */
    String POLICY_NO_COLLNAME = "policy";

    /**
     * 投保单号生成对应前缀
     */
    String PROPOSAL_NO_PREFIX = "T";

    /**
     * 保单号生成对应前缀
     */
    String POLICY_NO_PREFIX = "P";

    /**
     * 投保单号生成对应后缀长度
     */
    Integer PROPOSAL_NO_SIZE = 5;

    /**
     * 保单号生成对应后缀长度
     */
    Integer POLICY_NO_SIZE = 17;

    /**
     * 生成业务主键
     *
     * @return 主键ID
     */
    Long getPkId();

    /**
     * 生成投保单号
     *
     * @param prefix    投保单号前缀
     * @param endLength 末尾随机数长度
     * @return 投保单号
     */
    String getProposalNo(String prefix, int endLength);

    /**
     * 生成保单号
     *
     * @return 保单号
     */
    String getPolicyNo();

}