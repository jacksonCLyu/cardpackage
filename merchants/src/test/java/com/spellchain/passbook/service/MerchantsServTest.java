package com.spellchain.passbook.service;

import com.alibaba.fastjson.JSON;
import com.spellchain.passbook.vo.CreateMerchantsRequest;
import com.spellchain.passbook.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * @author jackson.yu
 * @version 1.0 2018年08月02日
 * @since 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@EnableAutoConfiguration
public class MerchantsServTest {

    @Autowired
    private IMerchantsServ merchantsServ;

    @Test
    @Transactional
    public void testCreateMerchantsServ(){
        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("spell");
        request.setLogoUrl("www.spellchain.com");
        request.setBusinessLicenseUrl("www.spellchain.com");
        request.setPhone("123456789");
        request.setAddress("北京市");

        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }
    /**
     * {"data":{"address":"???","businessLicenseUrl":"www.spellchain.com","id":3,"isAudit":false,"logoUrl":"www.spellchain.com","name":"spell","phone":"123456789"}}
     * {"errorCode":7,"errorMsg":"商户不存在"}
     * */
    @Test
    public void testBuildMerchantsByIdServ(){
        System.out.println(JSON.toJSONString(merchantsServ.buildMerchantsInfoById(3)));
    }

    @Test
    public void  testDropPassTemplate(){
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(3);
        passTemplate.setTitle("title: spell");
        passTemplate.setSummary("简介: spellchain");
        passTemplate.setDesc("详情: spellchain");
        passTemplate.setLimit(10000L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(new Date());
        passTemplate.setEnd(DateUtils.addDays(new Date(), 10));
        System.out.println(JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate)));
    }
}
