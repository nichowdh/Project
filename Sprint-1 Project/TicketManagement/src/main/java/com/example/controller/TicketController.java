package com.example.controller;

import javax.validation.Valid;

import com.example.dao.TicketDao;
import com.example.entity.Ticket;
import com.example.service.TicketService;
import com.example.exception.TicketNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping(path = "/tickets")
    public ResponseEntity<Ticket> saveTicket(@RequestBody @Valid Ticket ticketRequest) {
        try {
            Ticket ticket = ticketService.saveTicket(ticketRequest);
            return new ResponseEntity<>(ticket, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/tickets/{id}")
    public ResponseEntity<Ticket> getTicketByIdPath(@PathVariable int id) {
        try {
            Ticket ticket = ticketService.getTicketById(id);
            return ResponseEntity.ok().body(ticket);
        } catch (TicketNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}