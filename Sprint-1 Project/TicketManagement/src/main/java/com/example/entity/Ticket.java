package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Ticket { // entity class
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	// variables
	private int id;

	private String name;

	private String state;

	private String booking_date;

	private long phone;

	private String train;

	private String s_point;

	private String e_point;

}
