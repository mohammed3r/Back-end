package com.alrabiah.ServicesImplementation;

import com.alrabiah.Services.UserServices;
import com.alrabiah.dto.ObjectMapperUtils;
import com.alrabiah.dto.UserGetDto;
import com.alrabiah.dto.UsersDTO;
import com.alrabiah.entity.RolesEntity;
import com.alrabiah.entity.UsersEntity;
import com.alrabiah.repository.RolesRepository;
import com.alrabiah.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImp implements UserServices {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserGetDto> getAllUsers() {
        List<UsersEntity> usersEntities = usersRepository.findAll();
        List<UserGetDto> usersDTOS = ObjectMapperUtils.mapAll(usersEntities,UserGetDto.class);

        return usersDTOS;

    }

    @Override
    public List<UsersDTO> findAllPresent() {
        List<UsersEntity> usersEntities = usersRepository.findByEnabledIsTrue();
        List<UsersDTO> usersDTOS = ObjectMapperUtils.mapAll(usersEntities,UsersDTO.class);
        return usersDTOS;
    }

    @Override
    public UserGetDto findById(Long userid) {
//        if (usersRepository.findById(userid).isPresent()) {
            UsersEntity usersEntity = usersRepository.findById(userid).get();
            UserGetDto userGetDto = modelMapper.map(usersEntity, UserGetDto.class);
            return userGetDto;

    }

    // FIXME: 11/19/2018
    @Override
    public void addUser(UsersDTO usersDTO) {
        UsersEntity usersEntity = modelMapper.map(usersDTO,UsersEntity.class);
        usersEntity.setPassword(new BCryptPasswordEncoder().encode(usersDTO.getPassword()));
        usersEntity.setEnabled(true);
        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setRolename("ROLE_USER");
        rolesEntity.setRolename(usersEntity.getUsername());
        usersRepository.save(usersEntity);
        rolesRepository.save(rolesEntity);
    }

    @Override
    public void updateUser(UsersDTO usersDTO, Long userid) {

            if (usersRepository.findById(userid).isPresent()) {
                UsersEntity usersEntity;
                usersEntity = modelMapper.map(usersDTO, UsersEntity.class);
                usersEntity.setId(userid);
                usersEntity.setEnabled(usersRepository.findById(userid).get().isEnabled());
                usersEntity.setPassword(new BCryptPasswordEncoder().encode(usersDTO.getPassword()));
                usersRepository.saveAndFlush(usersEntity);
            }
    }

    @Override
    public void enableUser(Long userid,boolean b) {
        if (usersRepository.findById(userid).isPresent()) {
            UsersEntity usersEntity = usersRepository.findById(userid).get();
            usersEntity.setEnabled(b);
            usersRepository.save(usersEntity);
        }
    }

    @Override
    public UsersDTO findByUsername(String username) {
        UsersEntity usersEntity = usersRepository.findByUsername(username);
        UsersDTO usersDTO = modelMapper.map(usersEntity, UsersDTO.class);
        return usersDTO;
    }
}