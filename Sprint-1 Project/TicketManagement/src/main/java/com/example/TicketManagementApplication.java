//Code is Done by Niladri Chowdhury
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.repository.TicketRepo;

@SpringBootApplication
public class TicketManagementApplication {
    @Autowired
    private TicketRepo repo;

    public static void main(String[] args) {
        SpringApplication.run(TicketManagementApplication.class, args);
    }

}
