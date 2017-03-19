package com.lgh.spring.boot.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/3/19.
 */
@Entity
@Table(name = "auth_ticket")
public class MTicket {
    @Id
    @GenericGenerator(name = "UUID",strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    private String id;
    private String ticketId;
    private long effectiveTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public long getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(long effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
}
