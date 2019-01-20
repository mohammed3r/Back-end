package com.alrabiah.repository;

import com.alrabiah.entity.RolesEntity;
import com.alrabiah.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Long> {

    List<RolesEntity> findByUser(UsersEntity user);

}