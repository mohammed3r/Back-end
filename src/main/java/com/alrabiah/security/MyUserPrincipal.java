package com.alrabiah.security;

import com.alrabiah.Services.RoleServices;
import com.alrabiah.Services.UserServices;
import com.alrabiah.dto.RolesDTO;
import com.alrabiah.dto.UsersDTO;
import com.alrabiah.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserPrincipal implements UserDetails {

    @Autowired
    private RoleServices rolesRepository;
    @Autowired
    private UserServices userServices;
    @Autowired
    private UsersRepository usersRepository;

    private static final long serialVersionUID = 1L;

    private final UsersDTO user;

    //

    public MyUserPrincipal(UsersDTO user) {
        this.user = user;
    }

    //

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities ;
        authorities = new ArrayList<>();
        for (RolesDTO role : rolesRepository.findByUser(userServices.findByUsername(user.getUsername()))) {
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return  true;
    }

    @Override
    public boolean isEnabled() { return true; }

    //

    public UsersDTO getUser() {
        return user;
    }

}
