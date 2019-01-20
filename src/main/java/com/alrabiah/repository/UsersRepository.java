package com.alrabiah.repository;

import com.alrabiah.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

    List<UsersEntity> findByEnabledIsTrue();
    UsersEntity findByUsername(String uname);

}