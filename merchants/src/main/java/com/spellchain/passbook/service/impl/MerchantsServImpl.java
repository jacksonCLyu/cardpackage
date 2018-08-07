package com.spellchain.passbook.service.impl;

import com.alibaba.fastjson.JSON;
import com.spellchain.passbook.constant.Constants;
import com.spellchain.passbook.constant.ErrorCode;
import com.spellchain.passbook.dao.MerchantsDao;
import com.spellchain.passbook.entity.Merchants;
import com.spellchain.passbook.service.IMerchantsServ;
import com.spellchain.passbook.vo.CreateMerchantsRequest;
import com.spellchain.passbook.vo.CreateMerchantsResponse;
import com.spellchain.passbook.vo.PassTemplate;
import com.spellchain.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <h1>商户服务接口实现</h1>
 * @author jackson.yu
 * @version 1.0 2018年07月28日
 * @since 1.8
 */
@Slf4j
@Service
public class MerchantsServImpl implements IMerchantsServ {

    /** Merchants 数据库接口 */
    private final MerchantsDao merchantsDao;

    /** kafka 客户端 */
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MerchantsServImpl(MerchantsDao merchantsDao, KafkaTemplate<String, String> kafkaTemplate) {
        this.merchantsDao = merchantsDao;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Transactional
    public Response createMerchants(CreateMerchantsRequest request) {

        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();

        ErrorCode errorCode = request.validate(merchantsDao);
        if (errorCode != ErrorCode.SUCCESS){
            merchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        } else {
            merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
        }

        response.setData(merchantsResponse);

        return response;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {

        Response response = new Response();
        Merchants merchants = merchantsDao.queryById(id);
        if (null == merchants){
            response.setErrorCode(ErrorCode.MECHANTS_NOT_EXISTS.getCode());
            response.setErrorMsg(ErrorCode.MECHANTS_NOT_EXISTS.getDesc());
        }
        response.setData(merchants);
        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate passTemplate) {

        Response response = new Response();
        ErrorCode errorCode = passTemplate.validate(merchantsDao);
        if (errorCode != ErrorCode.SUCCESS){
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        } else {
            String template = JSON.toJSONString(passTemplate);
            kafkaTemplate.send(
                    Constants.TEMPLATE_TOPIC,
                    Constants.TEMPLATE_TOPIC,
                    template
            );
            log.info("DropPassTemplates:{}", passTemplate);
        }
        return response;
    }
}
