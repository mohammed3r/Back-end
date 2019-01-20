package com.alrabiah.repository;


import com.alrabiah.entity.EventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventsRepository extends JpaRepository<EventsEntity,Long> {
//    EventsEntity findByEventname (String eventname);
    List<EventsEntity> findAllByEventcity(String eventcity);
    List<EventsEntity> findByEventdate(LocalDate eventdate);
    Optional<EventsEntity> findByEventidAndDeletedFalseAndApprovedTrue(Long eventid);
    List<EventsEntity> findByDeletedFalseAndApprovedTrueAndEventdateAfter(LocalDate date);
    Optional<EventsEntity> findByEventidAndDeletedFalseAndApprovedTrueAndEventdateAfter(Long eventid,LocalDate date);
    Long countByApprovedTrue();
//    List<EventsEntity> findAll();

     }
