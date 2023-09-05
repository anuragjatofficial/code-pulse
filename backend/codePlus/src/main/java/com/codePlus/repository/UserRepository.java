package com.codePlus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codePlus.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("Select u from User u where u.Username=?1")
	public Optional<User> findByUserName(String message);
//	List<User> findByUsername (String username);
}
