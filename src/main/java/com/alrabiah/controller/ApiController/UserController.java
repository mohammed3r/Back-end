package com.alrabiah.controller.ApiController;

import com.alrabiah.NotificationService;
import com.alrabiah.Services.UserServices;
import com.alrabiah.dto.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserServices userServices;
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/UsersAccess/view")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity findAllPresent() {

        return ResponseEntity.ok(userServices.findAllPresent());
    }

    @GetMapping("/AdminAccess/view")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity getAllUser() {
        return ResponseEntity.ok(userServices.getAllUsers());
    }

    @GetMapping("/view/{userid}")
    public ResponseEntity findById(@PathVariable Long userid) {
        if (userServices.findById(userid) != null) {
            return ResponseEntity.ok(userServices.findById(userid));
        } return ResponseEntity.badRequest().body("No user");
    }
    @PostMapping("/addAdmin")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity addAdmin(@RequestBody @Valid UsersDTO usersDTO, BindingResult result) {
        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
//        notificationService.addUserNotification(usersDTO);
//        return ResponseEntity.ok(userServices.addUser(usersDTO));
 return ResponseEntity.ok().build();
    }


    @PostMapping("/addOrganizer")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity addOrganizer(@RequestBody @Valid UsersDTO usersDTO, BindingResult result) {
            if (result.hasErrors()){
                return ResponseEntity.badRequest().body(result.getAllErrors());
            }
//        notificationService.addUserNotification(usersDTO);
//        return ResponseEntity.ok(userServices.addUser(usersDTO));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addUser")
//    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity addUser(@RequestBody @Valid UsersDTO usersDTO, BindingResult result) {
        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

//        notificationService.addUserNotification(usersDTO);
        userServices.addUser(usersDTO);
        return ResponseEntity.created(null).build();
    }


    @PutMapping("/edit/{userid}")
    public ResponseEntity updateUser(@RequestBody @Valid UsersDTO usersDTO, @PathVariable Long userid, BindingResult result) {
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        userServices.updateUser(usersDTO, userid);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/delete/{userid}")
    public ResponseEntity deleteById(@PathVariable Long userid) {
        userServices.enableUser(userid,false);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/enable/{userid}")
    public ResponseEntity enableById(@PathVariable Long userid) {
        userServices.enableUser(userid,true);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{name}")
    public ResponseEntity findByUser(@PathVariable String name){
        return ResponseEntity.ok(userServices.findByUsername(name));
    }
}