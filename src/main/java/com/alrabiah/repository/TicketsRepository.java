package com.alrabiah.repository;

import com.alrabiah.entity.EventsEntity;
import com.alrabiah.entity.TicketsEntity;
import com.alrabiah.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketsRepository extends JpaRepository<TicketsEntity,Long> {


    Long countByEventidAndCanceledFalse(EventsEntity byId);
    Long countByUseridAndEventid(UsersEntity byUId,EventsEntity byEId);
    Long countByUseridAndDate(UsersEntity byId, LocalDate date);
    List<TicketsEntity> findByUserid(UsersEntity byId);
    List<TicketsEntity> findByEventid(EventsEntity byId);
    TicketsEntity findByUseridAndEventid(UsersEntity byUId,EventsEntity byEId);

}
