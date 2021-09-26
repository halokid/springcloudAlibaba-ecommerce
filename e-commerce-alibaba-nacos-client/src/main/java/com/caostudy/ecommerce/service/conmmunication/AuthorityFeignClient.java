package com.caostudy.ecommerce.service.conmmunication;

import com.caostudy.ecommerce.service.conmmunication.hystrix.AuthorityFeignClientFallback;
import com.caostudy.ecommerce.service.conmmunication.hystrix.AuthorityFeignClientFallbackFactory;
import com.caostudy.ecommerce.vo.JwtToken;
import com.caostudy.ecommerce.vo.UsernameAndPassword;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <h1>与 Authority 服务通信的 Feign Client 接口定义</h1>
 * */
@FeignClient(
        contextId = "AuthorityFeignClient", value = "e-commerce-authority-center",
        fallbackFactory = AuthorityFeignClientFallbackFactory.class
)
public interface AuthorityFeignClient {

    /**
     * <h2>通过 OpenFeign 访问 Authority 获取 Token</h2>
     * */
    @RequestMapping(value = "/ecommerce-authority-center/authority/token",
            method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    JwtToken getTokenByFeign(@RequestBody UsernameAndPassword usernameAndPassword);
}