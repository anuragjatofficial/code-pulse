package com.codePlus.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
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
