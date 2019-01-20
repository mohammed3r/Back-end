package com.alrabiah.controller.ApiController;

import com.alrabiah.NotificationService;
import com.alrabiah.Services.EventServices;
import com.alrabiah.dto.EventsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/events")
@Valid
@CrossOrigin
public class EventController {

    @Autowired
    private EventServices eventServices;
    @Autowired
    private NotificationService notificationService;



     @GetMapping("/UsersAccess/view")
     public ResponseEntity getAllActive() {
//         if(eventServices.getAllEvents().isEmpty()){
//         return ResponseEntity.noContent().build();
//     }
         return ResponseEntity.ok(eventServices.getAllActive());
     }

    @GetMapping("/AdminAccess/view")
    public ResponseEntity getAllEvents(){
//         if (eventServices.getAllEvents().isEmpty()){
//             return ResponseEntity.noContent().build(); }
         return ResponseEntity.ok(eventServices.getAllEvents());
     }

    @GetMapping("/view/{eventid}")
    public ResponseEntity findById(@PathVariable Long eventid){
//        if (!eventServices.findById(eventid).isPresent())
//        {
//            return ResponseEntity.noContent().build();
//        }
         return ResponseEntity.ok(eventServices.findById(eventid));
    }

    @PostMapping("/{userid}/add")
    public ResponseEntity addEvent(@RequestBody @Valid EventsDTO eventsDTO, @PathVariable Long userid, BindingResult result){
        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
         return ResponseEntity.ok(eventServices.addEvent(eventsDTO,userid));
     }

    @PutMapping("/edit/{eventid}")
    public ResponseEntity updateEvent(@RequestBody EventsDTO eventsDTO, @PathVariable Long eventid,BindingResult result) {
        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        notificationService.updateEventNotification(Long.valueOf(eventid));
        return ResponseEntity.ok(eventServices.updateEvent(eventsDTO,eventid));
}

    @PutMapping("/delete/{eventid}")
    public void deleteById(@PathVariable Long eventid){
         notificationService.eventCancelNotification(eventid);
         eventServices.deleteById(eventid);
     }

    @PutMapping("/AdminAccess/approve/{eventid}")
    public void eventAprrove(@PathVariable Long eventid){ eventServices.eventAprrove(eventid,true); }

    @PutMapping("/AdminAccess/unapprove/{eventid}")
    public void eventUnaprrove(@PathVariable Long eventid){ eventServices.eventAprrove(eventid,false); }


    @GetMapping("/AdminAccess/viewbylocation/{eventcity}")
    public ResponseEntity findAllByEventlocation(@PathVariable String eventcity) {
//        if (eventServices.findByCity(eventcity).isEmpty())
//        {
//            return ResponseEntity.noContent().build();
//        }
         return ResponseEntity.ok(eventServices.findByCity(eventcity));
    }
    @GetMapping("/AdminAccess/viewBydate/{eventdate}")
    public ResponseEntity findAllByEventdate(@PathVariable String eventdate) {
//        if (eventServices.findByDate(LocalDate.parse(eventdate)).isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
         return ResponseEntity.ok(eventServices.findByDate(LocalDate.parse(eventdate)));
     }


    @GetMapping("/viewifpresent/{eventid}")
    public ResponseEntity findIfPresent(@PathVariable Long eventid){
//    if (eventServices.findIfPresent(eventid).isPresent()){
//        return ResponseEntity.ok(eventServices.findIfPresent(eventid));
//    }
    return ResponseEntity.badRequest().build();
   }

   }






