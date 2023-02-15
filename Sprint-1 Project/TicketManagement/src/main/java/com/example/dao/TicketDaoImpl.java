package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Ticket;
import com.example.repository.TicketRepo;

@Repository
public class TicketDaoImpl implements TicketDao { // class

	@Autowired
	TicketRepo repo;

	@Override
	public void saveTicket(Ticket ticket) { // method 1
		repo.save(ticket);
	}

	@Override
	public Ticket getTicketById(int id) { // method 2
		return repo.findById(id).orElse(null);
	}
}
