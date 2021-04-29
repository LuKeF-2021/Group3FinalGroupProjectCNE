package com.qa.updateticketservice.persistence.domain;

import java.time.LocalDateTime;
import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "title")
	private String title;

	@Column(name = "complete")
	private Boolean complete;

	public Ticket(String name, String description, String title, Boolean complete) {
		super();
		this.name = name;
		this.description = description;
		this.title = title;
		this.complete = complete;
	}
	
	

}
