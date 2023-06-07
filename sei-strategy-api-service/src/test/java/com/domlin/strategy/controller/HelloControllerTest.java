package com.domlin.strategy.controller;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.core.util.JwtTokenUtil;
import com.changhong.sei.serial.sdk.SerialService;
import com.domlin.strategy.controller.HelloController;
import com.domlin.strategy.entity.StrategyAnalyzeBill;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * 实现功能: Hello 单元测试
 */
public class HelloControllerTest extends BaseUnitTest {
    @Autowired
    private HelloController controller;

    @Autowired(required = false)
    private SerialService serialService;

    @Test
    public void sayHello() {
        String name = "程序员";
        ResultData<String> result = controller.sayHello(name);
        LOG.debug(JsonUtils.toJson(result));
    }

    @Test
    public void geihao(){
        String number = serialService.getNumber(StrategyAnalyzeBill.class);
        System.out.println(number);
    }

    @Test
    public void getToken(){
        Map<String, Object> claims = new HashMap<>();
        String tenant = "DONLIM";
        String userId = "用户id";
        String account = "用户账号";
        String userName = "用户姓名";
        claims.put("tenant", tenant);
        claims.put("userId", "21B2F616-BA27-11EC-9755-0242AC14001A");
        claims.put("account", "admin");
        claims.put("userName", "租户管理员");
        claims.put("authorityPolicy","NormalUser");

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        jwtTokenUtil.setJwtExpiration(2880000);
        String t = jwtTokenUtil.generateToken(account, UUID.randomUUID().toString(), claims);
        // 将token放入header中 x-authorization
        System.out.println("Token: " + t);
        account = jwtTokenUtil.getSubjectFromToken(t);
        System.out.println(account);
    }

}
