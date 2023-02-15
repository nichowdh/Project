package com.example.dao;

import com.example.entity.Ticket;

public interface TicketDao {
    public void saveTicket(Ticket ticket);
    public Ticket getTicketById(int id);
}
