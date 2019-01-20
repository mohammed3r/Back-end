
package com.alrabiah;

import com.alrabiah.dto.UsersDTO;
import com.alrabiah.entity.EventsEntity;
import com.alrabiah.entity.TicketsEntity;
import com.alrabiah.entity.UsersEntity;
import com.alrabiah.repository.EventsRepository;
import com.alrabiah.repository.TicketsRepository;
import com.alrabiah.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NotificationService {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private TicketsRepository ticketsRepository;
	@Autowired
	private EventsRepository eventsRepository;
	@Autowired
	private UsersRepository usersRepository;


	public void addUserNotification(UsersDTO usersDTO) throws MailException {
		// send email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(usersDTO.getEmail());
		mail.setFrom("spring.mail.username");
		mail.setSubject("Hi " + usersDTO.getUsername());
		mail.setText("Hi " + usersDTO.getUsername() + ", we hope you're doing OK !\n" +
				"This Email to confirm your registeration\n" +
				"your name is: " + usersDTO.getUsername() + "\n" +
				"your first name is: " + usersDTO.getFirstname() + "\n" +
				"your last name is: " + usersDTO.getLastname() + "\n\n\n\n" +
				"Thanks for registration");

		javaMailSender.send(mail);
	}

	public void updateEventNotification(Long eventid) throws MailException {
//		 send email
		SimpleMailMessage mail = new SimpleMailMessage();
		EventsEntity eventsEntity = eventsRepository.findById(eventid).get();
//		mail.setTo(eventsEntity.getOrganizer().getEmail());
//		mail.setFrom("spring.mail.username");
//		mail.setSubject("Hi "+eventsEntity.getOrganizer().getUsername());
//		mail.setText("You have successfully update the event "+eventsEntity.getEventname());
//		javaMailSender.send(mail);

		List<TicketsEntity> ticketsEntity = ticketsRepository.findByEventid(eventsEntity);
		for (TicketsEntity ticketsEntity1 : ticketsEntity) {
				if(!ticketsEntity1.isChicked()) {
					mail.setTo(ticketsEntity1.getUserid().getEmail());
					mail.setFrom("spring.mail.username");
					mail.setSubject("Hi " + ticketsEntity1.getUserid().getUsername());
					mail.setText("Hi " + ticketsEntity1.getUserid().getUsername() + "\n"
							+ "your event " + eventsEntity.getEventname() + " date's has changed to " + eventsEntity.getEventdate());

					javaMailSender.send(mail);
				}
		}
	}


	public void eventCancelNotification(Long eventid) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		EventsEntity eventsEntity = eventsRepository.findById(eventid).get();
		List<TicketsEntity> ticketsEntity = ticketsRepository.findByEventid(eventsEntity);
		for (TicketsEntity ticketsEntity1 : ticketsEntity) {
			mail.setTo(ticketsEntity1.getUserid().getEmail());
			mail.setFrom("spring.mail.username");
			mail.setSubject("Hi " + ticketsEntity1.getUserid().getUsername());
			mail.setText("Hi " + ticketsEntity1.getUserid().getUsername() + "\n"
					+ "your event " + eventsEntity.getEventname() + " has been canceled !");

			javaMailSender.send(mail);
		}
	}

	public void bookTicketNotification(Long eventid,Long userid)
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		EventsEntity eventsEntity = eventsRepository.findById(eventid).get();
		UsersEntity usersEntity = usersRepository.findById(userid).get();
		TicketsEntity ticketsEntity = ticketsRepository.findByUseridAndEventid(usersEntity,eventsEntity);

	mail.setTo(usersEntity.getEmail());
		mail.setFrom("spring.mail.username");
		mail.setSubject("Hi " + usersEntity.getUsername());
		mail.setText("Hi " + usersEntity.getUsername() + "\n"
				+ "your booking for Event : " + eventsEntity.getEventname()
				+ " is confirmed!\n"
				+"your Ticket id is : "+ticketsEntity.getTicketid()+"Thanks.");

		javaMailSender.send(mail);

	}

	public void cancelTicketNotification(Long ticketid)
	{
		SimpleMailMessage mail = new SimpleMailMessage();
//		EventsEntity eventsEntity = eventsRepository.findById(eventid).get();
//		UsersEntity usersEntity = usersRepository.findById(userid).get();
		TicketsEntity ticketsEntity = ticketsRepository.findById(ticketid).get();
		mail.setTo(ticketsEntity.getUserid().getEmail());
		mail.setFrom("spring.mail.username");
		mail.setSubject("Hi " + ticketsEntity.getUserid().getUsername());
		mail.setText("Hi " + ticketsEntity.getUserid().getUsername() + "\n"
				+ "your booking for Event : " + ticketsEntity.getEventid().getEventname()
				+ " is confirmed!\n" +"Thanks.");
		javaMailSender.send(mail);

	}

}