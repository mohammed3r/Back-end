package com.alrabiah.dto;

import com.alrabiah.entity.EventsEntity;
import com.alrabiah.entity.UsersEntity;

public class TicketsDTO {
    // FIXME: 11/9/2018
    private long ticketid;
    private EventsEntity eventid;
    private UsersEntity userid;

    public long getTicketid() { return ticketid; }

    public void setTicketid(long ticketid) { this.ticketid = ticketid; }

    public String getEventid() { return eventid.getEventname(); }

    public void setEventid(EventsEntity eventid) { this.eventid = eventid; }

    public String getUserid() { return userid.getUsername(); }

    public void setUserid(UsersEntity userid) { this.userid = userid; }
}
