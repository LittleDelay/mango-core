package com.mango.compatibility.central.policy.service;

import com.bzn.central.api.util.CentralFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 核心保单通用接口
 *
 * @author Shangxp
 * @version 1.0.0
 * @since 2020/4/20 17:23
 */
@FeignClient(name = "bzn-central-service", configuration = CentralFeignConfiguration.class)
public interface PolicyCommonService extends com.bzn.central.api.policy.service.PolicyCommonService {

}