package com.codePlus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer answerId;
	@Column(columnDefinition = "text")
	private String answer;
}
