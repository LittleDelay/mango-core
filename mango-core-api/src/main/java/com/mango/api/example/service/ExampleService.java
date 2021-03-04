package com.mango.api.example.service;

import com.mango.api.common.constants.BackendConstants;
import com.mango.api.common.feign.BackendFeignConfig;
import com.mango.api.example.domain.request.QueryExampleListRequest;
import com.mango.api.example.domain.request.QueryExamplePageRequest;
import com.mango.api.example.domain.response.QueryExampleListResponse;
import com.mango.api.example.domain.response.QueryExamplePageResponse;
import com.mango.api.example.domain.response.QueryExampleResponse;
import com.bzn.util.page.PageListResponse;
import com.bzn.util.response.ResponseBzn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 示例接口（提供需要对其他服务暴露的接口）
 *
 * @author Shangxp
 * @version 1.0.0
 * @since 2020/4/20 21:01
 */
@FeignClient(name = BackendConstants.SERVICE_NAME, decode404 = true, configuration = BackendFeignConfig.class)
public interface ExampleService {

    String BASE_URL = "/api/backend/examples";

    /**
     * 查询示例
     *
     * @param exampleId 示例ID
     * @return 示例
     */
    @GetMapping(BASE_URL + "/{exampleId}")
    ResponseBzn<QueryExampleResponse> getExample(@PathVariable("exampleId") Long exampleId);

    /**
     * 查询示例列表
     *
     * @param queryExamplePageRequest 请求参数
     * @return 响应结果
     */
    @GetMapping(BASE_URL + "/page")
    ResponseBzn<PageListResponse<QueryExamplePageResponse>> queryExamplePage(
            @RequestParam QueryExamplePageRequest queryExamplePageRequest);

    /**
     * 查询示例集合
     *
     * @param queryExampleListRequest 请求参数
     * @return 响应结果
     */
    @GetMapping(BASE_URL)
    ResponseBzn<QueryExampleListResponse> queryExampleList(
            @RequestParam QueryExampleListRequest queryExampleListRequest);
}
