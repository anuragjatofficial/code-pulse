package com.codePlus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LoggedInUser {
	@Id
	private String username;
	private String userType;
}
