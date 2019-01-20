package com.alrabiah.Services;

import com.alrabiah.dto.EventsDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface EventServices {

    List<EventsDTO> getAllEvents() ;
    ResponseEntity findById(Long eventid) ;
    ResponseEntity addEvent(EventsDTO eventsDTO, Long userid);
    ResponseEntity updateEvent(EventsDTO eventsDTO,Long eventid);
    ResponseEntity deleteById(Long eventid);
    ResponseEntity eventAprrove(Long eventid,boolean aproved);
    ResponseEntity findByCity(String eventcity);
    ResponseEntity findByDate(LocalDate eventdate);
    ResponseEntity getAllActive();
    ResponseEntity findIfPresent(Long eventid);


    }
