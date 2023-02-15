package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TicketDaoImpl;
import com.example.entity.Ticket;
import com.example.exception.InvalidTicketException;
import com.example.repository.TicketRepo;
import com.example.validation.Validation;

@Service
public class TicketService { // service class to provide services

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
