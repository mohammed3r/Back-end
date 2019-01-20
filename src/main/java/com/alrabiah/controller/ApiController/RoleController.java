package com.alrabiah.controller.ApiController;

import com.alrabiah.Services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
public class RoleController {


    @Autowired
    private RoleServices roleServices;

    @GetMapping("/AdminAccess/view")
    public ResponseEntity getAllRoles(){

        return ResponseEntity.ok(roleServices.getAllRoles());
    }

    @GetMapping("/view/{roleid}")
    public ResponseEntity findById(@PathVariable Long roleid){

        return ResponseEntity.ok(roleServices.findById(roleid));
    }

}