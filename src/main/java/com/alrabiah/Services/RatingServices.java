package com.alrabiah.Services;

import com.alrabiah.dto.RatingDTO;
import org.springframework.http.ResponseEntity;

public interface RatingServices {
    ResponseEntity getAllRatings();
    ResponseEntity findById(Long rateid);
    ResponseEntity addRating(RatingDTO ratingDTO, Long ticketId);
    ResponseEntity updateRating(RatingDTO ratingDTO, Long rateid);


}
