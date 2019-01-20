package com.alrabiah.controller.ApiController;

import com.alrabiah.Services.RatingServices;
import com.alrabiah.dto.RatingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/rating")
public class RatingController {

    @Autowired
    private RatingServices ratingServices;

    @GetMapping("/AdminAccess/view")
    public ResponseEntity getAllRatings(){
//        if(ratingServices.getAllRatings().isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
        return ResponseEntity.ok(ratingServices.getAllRatings()); }

    @GetMapping("/view/{rateid}")
    public ResponseEntity findById(@PathVariable Long rateid) {
//        if (ratingServices.findById(rateid).isPresent()) {
//            return ResponseEntity.noContent().build();
//        }
        return ResponseEntity.ok(ratingServices.findById(rateid)); }

    @PostMapping("/add/{ticketid}")
    public ResponseEntity addRating (@RequestBody RatingDTO ratingDTO, @PathVariable  Long ticketid, BindingResult result){
        if (result.hasErrors())
        {
            ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return ResponseEntity.ok(ratingServices.addRating(ratingDTO,ticketid));
    }
    @PutMapping("/edit/{rateid}")
    public ResponseEntity updateRating(@RequestBody RatingDTO ratingDTO, @PathVariable Long rateid,BindingResult result) {

    if (result.hasErrors())
    {
        return ResponseEntity.badRequest().body(result.getAllErrors());
    }
        return ResponseEntity.ok(ratingServices.updateRating(ratingDTO, rateid));
    }

}