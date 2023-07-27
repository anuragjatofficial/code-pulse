package com.codePlus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Answer {
	@Id
	private Integer answerId;
	private String answer;
}
