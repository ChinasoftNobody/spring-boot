package com.lgh.spring.boot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/1.
 */
@RestController
@RequestMapping("/home")
@Api(tags = "home")
public class HomeController {
    @ApiOperation(value = "test",notes = "test")
    @PostMapping(value = "/test",name = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String test(){
        return "this is a test demo";
    }
}
