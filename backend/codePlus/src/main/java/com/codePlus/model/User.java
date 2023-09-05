package com.codePlus.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@NotBlank
	@Column(unique = true)
	private String Username;
	@NotBlank
	private String interviewType;
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<QuestionAnswers> qustionsAndAnswers = new ArrayList<>();
}
