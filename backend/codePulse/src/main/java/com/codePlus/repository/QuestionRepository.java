package com.codePlus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codePlus.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
