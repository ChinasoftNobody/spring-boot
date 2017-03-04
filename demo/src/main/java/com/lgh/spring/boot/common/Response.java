package com.lgh.spring.boot.common;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/4.
 */
public class Response implements Serializable{
    private String status;
    private Object result;

    public Response() {
    }

    public Response(String status, Object result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
