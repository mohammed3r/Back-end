package com.alrabiah.controller.ApiController;

import com.alrabiah.Services.UserServices;
import com.alrabiah.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class Login {


    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private UserServices userServices;

    @GetMapping("/UserData")

    public ResponseEntity login(Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
            Map<String, Object> map = new HashMap<>();
            map.put("userAuth", userDetails.getAuthorities());
            map.put("userId",  userServices.findByUsername(principal.getName()).getId());
        return ResponseEntity.ok(map);
    }
}
