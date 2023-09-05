package com.codePlus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Prompt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer promptId;
	@Column(columnDefinition = "TEXT")
	private String promptMessage;
}
