package com.alrabiah.Services;

import com.alrabiah.dto.UserGetDto;
import com.alrabiah.dto.UsersDTO;

import java.util.List;

public interface UserServices {

     List<UserGetDto> getAllUsers();
     List<UsersDTO> findAllPresent();
     UserGetDto findById(Long userid) ;
     void addUser(UsersDTO usersDTO);
     void updateUser(UsersDTO usersDTO, Long userid);
     void enableUser(Long userid,boolean b);
     UsersDTO findByUsername(String username);

    }