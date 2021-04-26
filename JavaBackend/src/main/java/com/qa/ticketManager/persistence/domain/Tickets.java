package com.qa.ticketManager.persistence.domain;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Tickets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
//	@Column(name = "email", unique = true)
//	private String email;
	
//	@Basic
//	@Temporal(TemporalType.DATE)
//	private java.util.Date creationDate;
	
	@CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "title")
	private String title;

	public Tickets(String firstName, String lastName, String description, String title) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.title = title;
	}
	
	

}
