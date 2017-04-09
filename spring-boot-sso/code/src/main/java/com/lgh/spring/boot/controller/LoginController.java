package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.pojo.login.LoginQuery;
import com.lgh.spring.boot.service.LoginService;
import com.lgh.spring.boot.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/19.
 */
@Controller
@RequestMapping("/login")
@Api(tags = "login")
public class LoginController {
    @Resource
    private LoginService loginService;

    @PostMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "用户登录",notes = "用户登录")
    @ResponseBody
    public Response login(@RequestBody LoginQuery query){
        if(loginService.validTicketLogin(query.getTicketId())){
            return ResponseUtil.ok(query.getTicketId());
        }
        String ticketId = loginService.login(query.getUserName(),query.getPassword());
        if(!StringUtils.isEmpty(ticketId)){
            return ResponseUtil.ok(ticketId);
        }
        return ResponseUtil.failed("login error");
    }
}
