package com.codePlus.services;

import java.util.List;

import com.codePlus.model.QuestionAnswers;

public interface ChatgptService {

	public String start(String userName);
	public QuestionAnswers feedBack(List<QuestionAnswers> Q);
}
