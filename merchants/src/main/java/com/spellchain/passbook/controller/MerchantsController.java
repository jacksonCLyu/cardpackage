package com.spellchain.passbook.controller;

import com.alibaba.fastjson.JSON;
import com.spellchain.passbook.service.IMerchantsServ;
import com.spellchain.passbook.vo.CreateMerchantsRequest;
import com.spellchain.passbook.vo.PassTemplate;
import com.spellchain.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <h1>商户服务 Controller</h1>
 * @author jackson.yu
 * @version 1.0 2018年08月07日
 * @since 1.8
 */
@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsController {

    /** 商户服务接口 */
    private final IMerchantsServ merchantsServ;

    @Autowired
    public MerchantsController(IMerchantsServ merchantsServ) {
        this.merchantsServ = merchantsServ;
    }

    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request){
        log.info("CreateMerchants:{}", JSON.toJSONString(request));
        return merchantsServ.createMerchants(request);
    }

    @GetMapping("/{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id){
        log.info("BuildMerchantsInfo:{}", id);
        return merchantsServ.buildMerchantsInfoById(id);
    }

    @PostMapping("/drop")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate){
        log.info("DropPassTemplate:{}", passTemplate);
        return merchantsServ.dropPassTemplate(passTemplate);
    }
}
