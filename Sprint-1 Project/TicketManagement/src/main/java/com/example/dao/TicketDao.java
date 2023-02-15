package com.example.dao;

import com.example.entity.Ticket;

public interface TicketDao { // interface
	public void saveTicket(Ticket ticket);

	public Ticket getTicketById(int id);
}
