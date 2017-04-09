package com.lgh.spring.boot.pojo.login;

/**
 * Created by Administrator on 2017/3/19.
 */
public class LoginQuery {
    private String ticketId;
    private String userName;
    private String password;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
