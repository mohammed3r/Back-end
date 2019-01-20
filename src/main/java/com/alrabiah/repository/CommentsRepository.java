package com.alrabiah.repository;

import com.alrabiah.entity.CommentsEntity;

import com.alrabiah.entity.EventsEntity;
import com.alrabiah.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsEntity,Long> {

    Long countByTheeventAndUseridAndCommenttimeAfter( EventsEntity EId , UsersEntity UId, LocalDateTime dateTime);
}
