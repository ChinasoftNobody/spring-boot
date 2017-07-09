package com.lgh.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/9.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index(@RequestParam String redirectTo, Map<String, Object> map) {
        if (!StringUtils.isEmpty(redirectTo)) {
            map.put("redirectTo",redirectTo);
        }
        return "login";
    }
}
