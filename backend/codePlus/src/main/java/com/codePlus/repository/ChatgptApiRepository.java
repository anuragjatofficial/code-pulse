package com.codePlus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codePlus.model.Chatgpt_API;

public interface ChatgptApiRepository extends JpaRepository<Chatgpt_API, Integer> {

	@Query("Select c.apiKey from Chatgpt_API c where c.id=1 ")
	public String getApiKey();
}
