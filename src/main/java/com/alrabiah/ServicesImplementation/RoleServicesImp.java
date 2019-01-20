package com.alrabiah.ServicesImplementation;

import com.alrabiah.Services.RoleServices;
import com.alrabiah.dto.ObjectMapperUtils;
import com.alrabiah.dto.RolesDTO;
import com.alrabiah.dto.UsersDTO;
import com.alrabiah.entity.RolesEntity;
import com.alrabiah.repository.RolesRepository;
import com.alrabiah.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServicesImp implements RoleServices {

    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<RolesDTO> getAllRoles() {

        List<RolesEntity> rolesEntityList = rolesRepository.findAll();
        List<RolesDTO> rolesDTOList = ObjectMapperUtils.mapAll(rolesEntityList,RolesDTO.class);
        return rolesDTOList;
    }

    @Override
    public RolesDTO findById(Long roleid) {
            RolesEntity rolesEntity = rolesRepository.findById(roleid).get();
            RolesDTO rolesDTO = modelMapper.map(rolesEntity,RolesDTO.class);
            return rolesDTO;

    }

    @Override
    public List<RolesDTO> findByUser(UsersDTO usersDTO){
        List<RolesEntity> rolesEntity = rolesRepository.findByUser(usersRepository.findByUsername(usersDTO.getUsername()));
        List<RolesDTO> rolesDTO =ObjectMapperUtils.mapAll(rolesEntity,RolesDTO.class);
//        modelMapper.map(rolesEntity,RolesDTO.class);

        return rolesDTO;
    }

}