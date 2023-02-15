package com.example.service;

import com.example.dao.TicketDaoImpl;
import com.example.exception.InvalidTicketException;
import com.example.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TicketDao;
import com.example.entity.Ticket;
import com.example.exception.TicketNotFoundException;
import com.example.repository.TicketRepo;

@Service
public class TicketService {

	@Autowired
	private TicketRepo ticketRepository;

	@Autowired
	private TicketDaoImpl ticketDaoImpl;

	public Ticket saveTicket(Ticket ticketRequest) throws InvalidTicketException, InvalidTicketException {
			Validation.validateTicket(ticketRequest);
			return ticketRepository.save(ticketRequest);
	}

	public Ticket getTicketById(int id) {
		return ticketDaoImpl.getTicketById(id);
	}
}
