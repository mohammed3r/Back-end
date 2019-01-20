package com.alrabiah.ServicesImplementation;

import com.alrabiah.Services.EventServices;
import com.alrabiah.dto.EventsDTO;
import com.alrabiah.dto.ObjectMapperUtils;
import com.alrabiah.entity.EventsEntity;
import com.alrabiah.repository.EventsRepository;
import com.alrabiah.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventServicesImp implements EventServices {

    @Autowired
    private EventsRepository eventsRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UsersRepository usersRepository;


    @Override
    public List<EventsDTO> getAllEvents() {
        if (!eventsRepository.findAll().isEmpty()) {
            List<EventsEntity> eventsEntityList = eventsRepository.findAll();
            List<EventsDTO> eventsDTO = ObjectMapperUtils.mapAll(eventsEntityList, EventsDTO.class);
            return eventsDTO;
        }
        return null;
    }
    @Override
    public ResponseEntity findById(Long eventid) {
        if (eventsRepository.findById(eventid).isPresent()) {
            EventsEntity eventsEntity = eventsRepository.findById(eventid).get();
            EventsDTO eventsDTO = modelMapper.map(eventsEntity, EventsDTO.class);
            return ResponseEntity.ok(eventsDTO);
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity addEvent(EventsDTO eventsDTO, Long userid) {

        if (eventsDTO.getEventdate().isAfter(LocalDate.now().minusDays(1)))
        {
            EventsEntity eventsEntity;
            eventsEntity = modelMapper.map(eventsDTO, EventsEntity.class);

            eventsEntity.setOrganizer(usersRepository.findById(userid).get());
            return ResponseEntity.ok(eventsRepository.save(eventsEntity));
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity updateEvent(EventsDTO eventsDTO, Long eventid) {
        if (eventsRepository.findById(eventid).isPresent()) {
            EventsEntity eventsEntity1 = eventsRepository.findById(eventid).get();
            EventsEntity eventsEntity;
            eventsEntity = modelMapper.map(eventsDTO, EventsEntity.class);
            eventsEntity.setEventid(eventsEntity1.getEventid());
            eventsEntity.setOrganizer(eventsEntity1.getOrganizer());
            eventsEntity.setComments(eventsEntity1.getComments());
            return ResponseEntity.ok(eventsRepository.save(eventsEntity));
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity deleteById(Long eventid) {
        if (eventsRepository.findById(eventid).isPresent()) {
            EventsEntity eventsEntity = eventsRepository.findById(eventid).get();
            eventsEntity.setDeleted(true);
            return ResponseEntity.ok(eventsRepository.save(eventsEntity));
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity eventAprrove(Long eventid, boolean aproved) {
        if (eventsRepository.findById(eventid).isPresent()) {
            EventsEntity eventsEntity = eventsRepository.findById(eventid).get();
            eventsEntity.setApproved(aproved);
            return ResponseEntity.ok(eventsRepository.save(eventsEntity));
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity findByCity(String eventcity) {
        if (!eventsRepository.findAllByEventcity(eventcity).isEmpty()) {
            List<EventsEntity> eventsEntityList = eventsRepository.findAllByEventcity(eventcity);
            List<EventsDTO> eventsDTOList = ObjectMapperUtils.mapAll(eventsEntityList, EventsDTO.class);
            return ResponseEntity.ok(eventsDTOList);
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity findByDate(LocalDate eventdate) {
        if (!eventsRepository.findByEventdate(eventdate).isEmpty()) {
            List<EventsEntity> eventsEntityList = eventsRepository.findByEventdate(eventdate);
            List<EventsDTO> eventsDTOList = ObjectMapperUtils.mapAll(eventsEntityList, EventsDTO.class);
            return ResponseEntity.ok(eventsDTOList);
        }
        return ResponseEntity.noContent().build();
    }


    @Override
    public ResponseEntity getAllActive() {

        LocalDate localDate = LocalDate.now();
        if (!eventsRepository.findByDeletedFalseAndApprovedTrueAndEventdateAfter(localDate).isEmpty()) {
            List<EventsEntity> eventsEntityList = eventsRepository.findByDeletedFalseAndApprovedTrueAndEventdateAfter(localDate);
            List<EventsDTO> eventsDTOList = ObjectMapperUtils.mapAll(eventsEntityList, EventsDTO.class);
            return ResponseEntity.ok(eventsDTOList);
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity findIfPresent(Long eventid) {
        LocalDate date = LocalDate.now();
        if (eventsRepository.findByEventidAndDeletedFalseAndApprovedTrueAndEventdateAfter(eventid, date).isPresent()) {
            EventsEntity eventsEntity = eventsRepository.findById(eventid).get();
            EventsDTO eventsDTO = modelMapper.map(eventsEntity, EventsDTO.class);
            return ResponseEntity.ok(eventsDTO);
        }
        return ResponseEntity.noContent().build();
    }

}