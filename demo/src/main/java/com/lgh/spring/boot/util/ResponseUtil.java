package com.lgh.spring.boot.util;

import com.lgh.spring.boot.common.Response;

/**
 * Created by Administrator on 2017/3/4.
 */
public class ResponseUtil {

    private static final String FAILED = "failed";
    private static final String OK = "ok";

    public static Response ok(Object result){
        return new Response(OK,result);
    }

    public static Response failed(String reason){
        return new Response(FAILED,reason);
    }
}
