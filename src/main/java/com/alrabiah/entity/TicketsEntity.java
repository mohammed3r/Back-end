package com.alrabiah.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="TICKET")
public class TicketsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketid;
    @ManyToOne
    private EventsEntity eventid;
    @ManyToOne
    private UsersEntity userid;
    @ColumnDefault("0")
    private boolean chicked;
    @ColumnDefault("0")
    private boolean canceled;
    private LocalDate date;

    public long getTicketid() { return ticketid; }

    public void setTicketid(long ticketid) { this.ticketid = ticketid; }

    public EventsEntity getEventid() { return eventid; }

    public void setEventid(EventsEntity eventid) { this.eventid = eventid; }

    public UsersEntity getUserid() { return userid; }

    public void setUserid(UsersEntity userid) { this.userid = userid; }

    public boolean isChicked() { return chicked; }

    public void setChicked(boolean chicked) { this.chicked = chicked; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public boolean isCanceled() { return canceled; }

    public void setCanceled(boolean canceled) { this.canceled = canceled; }
}
