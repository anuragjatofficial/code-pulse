package com.codePlus.services;

import com.codePlus.exceptions.UserNotFoundException;
import com.codePlus.model.QuestionAnswers;
import com.codePlus.model.User;

public interface UserService {
	User addUser(User user);
	QuestionAnswers addChat(QuestionAnswers questionAnswers, String username) throws UserNotFoundException;
	User findByUsername(String username) throws UserNotFoundException;
	QuestionAnswers addQuestions(String[] quesitons , String username);
}
