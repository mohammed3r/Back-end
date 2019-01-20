package com.alrabiah.Services;

import com.alrabiah.dto.RolesDTO;
import com.alrabiah.dto.UsersDTO;

import java.util.List;

public interface RoleServices {


    List<RolesDTO> getAllRoles();

    RolesDTO  findById(Long roleid);

    List<RolesDTO> findByUser(UsersDTO usersDTO);
}


