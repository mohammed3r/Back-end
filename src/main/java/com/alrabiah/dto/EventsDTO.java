package com.alrabiah.dto;

import java.time.LocalDate;

public class EventsDTO {

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

//    public List<CommentsEntity> getComments() { return comments; }

//    public void setComments(List<CommentsEntity> comments) { this.comments = comments; }

    public String getEventname() { return eventname; }

    public void setEventname(String eventname) { this.eventname = eventname; }

    public long getEventcapacity() { return eventcapacity; }

    public void setEventcapacity(long eventcapacity) {
        this.eventcapacity = eventcapacity;
    }

    public String getEventoverview() {
        return eventoverview;
    }

    public void setEventoverview(String eventoverview) {
        this.eventoverview = eventoverview;
    }

    public LocalDate getEventdate() {
        return eventdate;
    }

    public void setEventdate(LocalDate eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }

    public String getEventimage() {
        return eventimage;
    }

    public void setEventimage(String eventimage) {
        this.eventimage = eventimage;
    }

    public int getMinage() {
        return minage;
    }

    public void setMinage(int minage) {
        this.minage = minage;
    }

    public String getEventgender() {
        return eventgender;
    }

    public void setEventgender(String eventgender) {
        this.eventgender = eventgender;
    }

    public String getEventcategory() {
        return eventcategory;
    }

    public void setEventcategory(String eventcategory) {
        this.eventcategory = eventcategory;
    }

    public String getEventcity() {
        return eventcity;
    }

    public void setEventcity(String eventcity) {
        this.eventcity = eventcity;
    }

    public String getEventlocation() {
        return eventlocation;
    }

    public void setEventlocation(String eventlocation) {
        this.eventlocation = eventlocation;
    }

}
