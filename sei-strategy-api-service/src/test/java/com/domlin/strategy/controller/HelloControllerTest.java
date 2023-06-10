package com.domlin.strategy.controller;

import com.changhong.sei.basic.api.SysUserApi;
import com.changhong.sei.basic.dto.SysUserDto;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.core.util.JwtTokenUtil;
import com.changhong.sei.serial.sdk.SerialService;
import com.domlin.strategy.entity.StrategyAnalyzeBill;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
        claims.put("userId", "ACA47EF2-CE6A-11ED-BBDF-0242AC120011");
        claims.put("account", "381669");
        claims.put("userName", "何爵为");
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
