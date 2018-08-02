package com.spellchain.passbook.service;

import com.spellchain.passbook.vo.CreateMerchantsRequest;
import com.spellchain.passbook.vo.PassTemplate;
import com.spellchain.passbook.vo.Response;

/**
 * <h1>对商户服务接口定义</h1>
 * @author jackson.yu
 * @version 1.0 2018年07月28日
 * @since 1.8
 */
public interface IMerchantsServ {

    /**
     * <h2>创建商户服务</h2>
     * @param request {@link CreateMerchantsRequest} 创建商户请求
     * @return {@link Response}
     */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * <h2>根据 id 构造商户信息</h2>
     * @param id 商户 id
     * @return {@link Response}
     */
    Response buildMerchantsInfoById(Integer id);

    /**
     * <h2>投放优惠券</h2>
     * @param passTemplate {@link PassTemplate} 优惠券对象
     * @return {@link Response}
     */
    Response dropPassTemplate(PassTemplate passTemplate);
}
