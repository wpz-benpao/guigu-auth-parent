package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "用户登录接口")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    //根据前端模板登录提供的响应信息：{"code":20000,"data":{"token":"admin-token"}}
    //Result类中没有定义20000的状态码，这需要在前端中实现
    @PostMapping("login")
    public Result login(){
        Map<String,Object> map=new HashMap<>();
        map.put("token","admin-token-atguigu");
        return Result.ok(map);
    }

    //根据前端模板登录提供的响应信息：
    // {"code":20000,
    // "data":{"roles":["admin"],
    // "introduction":"I am a super administrator",
    // "avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
    // "name":"Super Admin"}}
    @GetMapping("info")
    public Result info(){
        Map<String,Object> map=new HashMap<>();
        map.put("roles","[admin]");
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin atguigu");
        return Result.ok(map);
    }

    @PostMapping("logout")
    public Result logout(){
        return Result.ok();
    }

}
