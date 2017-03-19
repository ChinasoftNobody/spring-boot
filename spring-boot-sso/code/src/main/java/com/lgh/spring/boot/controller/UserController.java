package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.pojo.user.QueryUserQuery;
import com.lgh.spring.boot.util.ResponseUtil;
import com.lgh.spring.boot.pojo.user.AddUserQuery;
import com.lgh.spring.boot.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/4.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加用户", notes = "添加用户")
    @ResponseBody
    public Response addUser(@RequestBody AddUserQuery user) {
        if (userService.addUser(user)) {
            return ResponseUtil.ok("success");
        }
        return ResponseUtil.failed("save error");
    }

    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询用户列表",notes = "查询用户列表")
    @ResponseBody
    public Response queryUser(@RequestBody QueryUserQuery queryUserQuery) {
        return ResponseUtil.ok(userService.query(queryUserQuery));
    }
}
