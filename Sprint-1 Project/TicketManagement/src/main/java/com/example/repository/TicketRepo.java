package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> { // interface

}
