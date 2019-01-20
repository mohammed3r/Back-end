package com.alrabiah.controller.ApiController;

import com.alrabiah.NotificationService;
import com.alrabiah.Services.TicketServices;

import com.alrabiah.dto.TicketsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin
public class TicketController {


    @Autowired
    private TicketServices ticketServices;
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/AdminAccess/view")
    public List<TicketsDTO> getAllTickets() {
//        return ResponseEntity.ok(ticketServices.getAllTickets());
        return ticketServices.getAllTickets();
    }

    @GetMapping("/view/{ticketid}")
    public ResponseEntity findById(@PathVariable Long ticketid) {
        return ResponseEntity.ok(ticketServices.findById(ticketid));
    }


    @PostMapping("/add/{eventid}/{userid}")
    public void addTicket(@PathVariable Long eventid, @PathVariable Long userid) {
//        notificationService.bookTicketNotification(eventid,userid);
//        return ResponseEntity.ok(ticketServices.addTicket(eventid , userid));
        ticketServices.addTicket(eventid, userid);
    }
    @GetMapping("/count/{eventid}")
    public ResponseEntity CountEventTickets(@PathVariable Long eventid) {
        return ResponseEntity.ok(ticketServices.CountEventTickets(eventid));
    }

    @GetMapping("mytickets/{userid}")
    public ResponseEntity findMyTickets(@PathVariable Long userid) {

        return ResponseEntity.ok(ticketServices.findMyTickets(userid));
    }

    @GetMapping("/chickin/{ticketid}")
    public ResponseEntity ChickinTicket(@PathVariable Long ticketid) {
        return ResponseEntity.ok(ticketServices.ChickinTicket(ticketid));
    }

    @GetMapping("/cancel/{ticketid}")
    public ResponseEntity CancelTicket(@PathVariable Long ticketid) {
        return ResponseEntity.ok(ticketServices.CancelTicket(ticketid));
    }
}