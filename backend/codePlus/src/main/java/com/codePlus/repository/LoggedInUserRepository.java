package com.codePlus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codePlus.model.LoggedInUser;

public interface LoggedInUserRepository extends JpaRepository<LoggedInUser, String> {

}
