package com.lgh.spring.boot.service;

import com.lgh.spring.boot.common.Response;

/**
 * Created by Administrator on 2017/3/19.
 */
public interface LoginService {
    /**
     * 验证ticket是否存在，且有效，若有效则登陆成功
     * @param ticketId ticketId
     * @return 结果true成功，false失败
     */
    boolean validTicketLogin(String ticketId);

    /**
     * 使用用户名及密码登录
     * @param userName 用户名
     * @param passWord 密码
     * @return 登陆结果
     */
    String login(String userName, String passWord);

    /**
     * 检验ticket
     * @param ticket sso_ticket
     * @return 检验结果
     */
    Response loginStatus(String ticket);
}
