package com.alrabiah.ServicesImplementation;

import com.alrabiah.Services.RatingServices;
import com.alrabiah.dto.ObjectMapperUtils;
import com.alrabiah.dto.RatingDTO;
import com.alrabiah.entity.RatingEntity;
import com.alrabiah.entity.TicketsEntity;
import com.alrabiah.repository.RatingRepository;
import com.alrabiah.repository.TicketsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServicesImp implements RatingServices {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private TicketsRepository ticketsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity getAllRatings() {
        if (!ratingRepository.findAll().isEmpty()) {
            List<RatingEntity> ratingEntityList = ratingRepository.findAll();
            List<RatingDTO> ratingDTOList = ObjectMapperUtils.mapAll(ratingEntityList, RatingDTO.class);
            return ResponseEntity.ok(ratingDTOList);
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity  findById(Long rateid) {
        if (ratingRepository.findById(rateid).isPresent()) {
            RatingEntity ratingEntity = ratingRepository.findById(rateid).get();
            RatingDTO ratingDTO = modelMapper.map(ratingEntity,RatingDTO.class);
            return ResponseEntity.ok(ratingDTO);
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity addRating(RatingDTO ratingDTO, Long ticketId) {

        TicketsEntity ticketsEntity = ticketsRepository.findById(ticketId).get();
        if (ticketsEntity.isChicked())
        {
            RatingEntity ratingEntity = modelMapper.map(ratingDTO,RatingEntity.class);

            ratingEntity.setTicket(ticketsEntity);
            return ResponseEntity.ok(ratingRepository.save(ratingEntity));
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity updateRating(RatingDTO ratingDTO, Long rateid) {
        // FIXME: 11/7/2018
        if (ratingRepository.findById(rateid).isPresent()) {
            RatingEntity ratingEntity = modelMapper.map(ratingDTO, RatingEntity.class);
            ratingEntity.setRateid(ratingEntity.getRateid());
            ratingEntity.setTicket(ratingEntity.getTicket());
            return ResponseEntity.ok(ratingRepository.save(ratingEntity));
        }
        return ResponseEntity.badRequest().build();
    }
}