package com.lgh.spring.boot.service.impl;

import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.model.MTicket;
import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.repo.TicketRepo;
import com.lgh.spring.boot.repo.UserRepo;
import com.lgh.spring.boot.service.LoginService;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Administrator on 2017/3/19.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private TicketRepo ticketRepo;
    @Resource
    private UserRepo userRepo;

    @Override
    public boolean validTicketLogin(String ticketId) {
        if (StringUtils.isEmpty(ticketId)) {
            return false;
        }
        MTicket ticket = ticketRepo.findByTicketId(ticketId);
        if (ticket != null && (ticket.getEffectiveTime() - System.currentTimeMillis() <= 7200*1000)) {
            return true;
        }
        return false;
    }

    @Override
    public String login(String userName, String passWord) {
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)){
            return null;
        }
        MUser user = userRepo.findByName(userName);
        if(user != null && passWord.equals(user.getPassword())){
            MTicket ticket = new MTicket();
            ticket.setTicketId(UUID.randomUUID().toString().replaceAll("-",""));
            ticket.setEffectiveTime(System.currentTimeMillis() + 7200*1000);
            ticketRepo.save(ticket);
            return ticket.getTicketId();
        }
        return null;
    }

    @Override
    public Response loginStatus(String ticket) {
        MTicket mTicket = ticketRepo.findByTicketId(ticket);
        if(mTicket == null){
            return ResponseUtil.failed("ticket not fount in database");
        }
        if(System.currentTimeMillis() > mTicket.getEffectiveTime()){
            return ResponseUtil.failed("ticket time out");
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("access",true);
        map.put("msg","ticket correct");
        return ResponseUtil.ok(map);
    }
}
