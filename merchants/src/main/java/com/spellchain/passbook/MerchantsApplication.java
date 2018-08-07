package com.spellchain.passbook;

import com.spellchain.passbook.security.AuthCheckIntercepter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@SpringBootApplication
public class MerchantsApplication  extends WebMvcConfigurerAdapter  {

    public static void main(String[] args) {
        SpringApplication.run(MerchantsApplication.class, args);
    }

    @Resource
    private AuthCheckIntercepter authCheckIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(authCheckIntercepter).addPathPatterns("/merchants/**");
        super.addInterceptors(registry);
    }
}
