package com.example.dao;

import com.example.entity.Ticket;
import com.example.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TicketDaoImpl implements TicketDao  {

    @Autowired
    TicketRepo repo;

    @Override
    public void saveTicket(Ticket ticket) {
        repo.save(ticket);
    }

    @Override
    public Ticket getTicketById(int id) {
        return repo.findById(id).orElse(null);
    }
}
