package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Ticket;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

}
