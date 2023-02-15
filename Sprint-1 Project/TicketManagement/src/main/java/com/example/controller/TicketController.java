package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Ticket;
import com.example.exception.TicketNotFoundException;
import com.example.service.TicketService;

@RestController
@RequestMapping(value = "/api")
public class TicketController {
	@Autowired
	private TicketService ticketService;

//insert the data to the table 
	@PostMapping(path = "/tickets")
	public ResponseEntity<Ticket> saveTicket(@RequestBody @Valid Ticket ticketRequest) {
		try {
			Ticket ticket = ticketService.saveTicket(ticketRequest);
			return new ResponseEntity<>(ticket, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

//to get the data of a single ticket
	@GetMapping(path = "/getticket/{id}")
	public ResponseEntity<Ticket> getTicketByIdPath(@PathVariable int id) {
		try {
			Ticket ticket = ticketService.getTicketById(id);
			return ResponseEntity.ok().body(ticket);
		} catch (TicketNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}