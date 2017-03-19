package com.lgh.spring.boot.repo;

import com.lgh.spring.boot.model.MTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Administrator on 2017/3/19.
 */
public interface TicketRepo extends JpaRepository<MTicket,String> {

    MTicket findByTicketId(@Param("ticketId") String ticketId);
}
