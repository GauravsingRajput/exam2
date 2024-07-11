package com.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Railway {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name is Mandatory")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Category is mandatory")
	private Category category;
	
	private LocalDateTime start_time;
	
	private LocalDateTime  end_time;
	
	@NotBlank(message = "Source is mandatory")
	private String source;
	
	@NotBlank(message = "Destination is mandatory")
	private String destination;
	
	@NotBlank(message = "Station code is mandatory")
	private String stationcode;
	
	@NotNull(message = "Distance is mandatory")
	private double distance;
	
	@NotBlank(message = "Frequency is mandatory")
	private String frequency;
	
}
