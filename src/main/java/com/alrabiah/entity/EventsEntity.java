package com.alrabiah.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "EVENTS" )
public class EventsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eventid;
    private String eventname;
    private long eventcapacity;
    private String eventoverview;
    private LocalDate eventdate;
    private String eventtime;
    private String eventimage;
    private int minage;
    private String eventgender;
    private String eventcategory;
    private String eventcity;
    private String eventlocation;
    @ColumnDefault("0")
    @JsonIgnore
    private boolean deleted;
    @ColumnDefault("0")
    @JsonIgnore
    private boolean approved;
    @ManyToOne(cascade = CascadeType.ALL)
    private UsersEntity organizer;
        @OneToMany(mappedBy = "theevent")
    private List<CommentsEntity> comments;


    public long getEventid() { return eventid; }

    public void setEventid(long eventid) { this.eventid = eventid; }

    public String getEventname() { return eventname; }

    public void setEventname(String eventname) { this.eventname = eventname; }

    public long getEventcapacity() { return eventcapacity; }

    public void setEventcapacity(long eventcapacity) { this.eventcapacity = eventcapacity; }

    public String getEventoverview() { return eventoverview; }

    public void setEventoverview(String eventoverview) { this.eventoverview = eventoverview; }

    public LocalDate getEventdate() { return eventdate; }

    public void setEventdate(LocalDate eventdate) { this.eventdate = eventdate; }

    public String getEventtime() { return eventtime; }

    public void setEventtime(String eventtime) { this.eventtime = eventtime; }

    public String getEventimage() { return eventimage; }

    public void setEventimage(String eventimage) { this.eventimage = eventimage; }

    public int getMinage() { return minage; }

    public void setMinage(int minage) { this.minage = minage; }

    public String getEventgender() { return eventgender; }

    public void setEventgender(String eventgender) { this.eventgender = eventgender; }

    public String getEventcategory() { return eventcategory; }

    public void setEventcategory(String eventcategory) { this.eventcategory = eventcategory; }

    public String getEventcity() { return eventcity; }

    public void setEventcity(String eventcity) { this.eventcity = eventcity; }

    public String getEventlocation() { return eventlocation; }

    public void setEventlocation(String eventlocation) { this.eventlocation = eventlocation; }

    public boolean isDeleted() { return deleted; }

    public void setDeleted(boolean deleted) { this.deleted = deleted; }

    public boolean isApproved() { return approved; }

    public void setApproved(boolean approved) { this.approved = approved; }

    public UsersEntity getOrganizer() { return organizer; }

    public void setOrganizer(UsersEntity organizer) { this.organizer = organizer; }

    public List<CommentsEntity> getComments() { return comments; }

    public void setComments(List<CommentsEntity> comments) { this.comments = comments; }
}