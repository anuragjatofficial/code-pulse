package com.codePlus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Question {
	@Id
	private Integer questionId;
	private String question;
}
