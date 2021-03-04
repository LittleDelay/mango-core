package com.mango.common.service.impl;

import com.mango.common.service.IdGenerationService;
import com.bzn.id.api.service.IdService;
import com.bzn.id.api.service.IdServiceHttpImpl;
import com.bzn.util.key.KeyUtil;
import com.bzn.util.rand.RandCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ID生成接口实现类
 *
 * @author Shangxp
 * @version 1.0.0
 * @since 2020/4/20 16:47
 */
@Service("idGenerationService")
public class IdGenerationServiceImpl implements IdGenerationService {

    private IdService idService;

    @Autowired
    public void setIdService(IdServiceHttpImpl idService) {
        this.idService = idService;
    }

    /**
     * 生成业务主键
     *
     * @return 主键ID
     */
    @Override
    public Long getPkId() {
        return this.idService.getId();
    }

    /**
     * 生成投保单号
     *
     * @param prefix    投保单号前缀
     * @param endLength 末尾随机数长度
     * @return 投保单号
     */
    @Override
    public String getProposalNo(String prefix, int endLength) {
        return KeyUtil.createApplicantCodeToyyyyMMdd(prefix) + RandCodeUtils.getRandCode(endLength);
    }

    /**
     * 生成保单号
     *
     * @return 保单号
     */
    @Override
    public String getPolicyNo() {
        return idService.getFormatId(POLICY_NO_PREFIX, POLICY_NO_SIZE + "", POLICY_NO_COLLNAME);
    }

}