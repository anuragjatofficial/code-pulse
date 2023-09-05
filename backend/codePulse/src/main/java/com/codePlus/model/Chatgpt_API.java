package com.codePlus.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Chatgpt_API {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String apiKey;
	
	
	
}
