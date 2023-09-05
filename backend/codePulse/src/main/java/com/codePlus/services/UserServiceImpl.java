package com.codePlus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codePlus.exceptions.InvalidDataException;
import com.codePlus.exceptions.QuestionException;
import com.codePlus.exceptions.UserNotFoundException;
import com.codePlus.model.QuestionAnswers;
import com.codePlus.model.User;
import com.codePlus.repository.AnswerRepository;
import com.codePlus.repository.QuestionRepository;
import com.codePlus.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private ChatgptSerivceImpl chatGptService;

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public User addUser(User user) {

		if (user != null) {
			User user2 = userRepository.findByUserName(user.getUsername()).orElse(null);
			if (user2 == null)
				return userRepository.save(user);
			else
				return user2;
		} else
			throw new InvalidDataException("can't pass null value");
	}

	@Override
	public QuestionAnswers addChat(QuestionAnswers questionAnswers, String username) throws UserNotFoundException {
		User user = findByUsername(username);

		int size = user.getQustionsAndAnswers().size() - 1;
		int lastQid = user.getQustionsAndAnswers().get(size).getQuestionAnswerId();

		if (questionAnswers.getQuestionAnswerId() == lastQid) {

			user.getQustionsAndAnswers().stream()
			.filter(a -> a.getQuestionAnswerId().equals(questionAnswers.getQuestionAnswerId())).findAny().get()
			.setAnswer(questionAnswers.getAnswer());
			userRepository.save(user);
			return chatGptService.feedBack(user.getQustionsAndAnswers());

		} else {

			user.getQustionsAndAnswers().stream()
					.filter(a -> a.getQuestionAnswerId().equals(questionAnswers.getQuestionAnswerId())).findAny().get()
					.setAnswer(questionAnswers.getAnswer());
			userRepository.save(user);
			return user.getQustionsAndAnswers().stream()
					.filter(a -> a.getQuestionAnswerId().equals(questionAnswers.getQuestionAnswerId() + 1)).findAny()
					.orElseThrow(() -> new QuestionException("can't pass question please try later "));

		}
	}

	@Override
	public User findByUsername(String username) throws UserNotFoundException {
		return userRepository.findByUserName(username)
				.orElseThrow(() -> new UserNotFoundException("can't find any user with username " + username));
	}

	@Override
	public QuestionAnswers addQuestions(String[] questions, String username) {
		User user = findByUsername(username);

		for (int i = 0; i < questions.length; i++) {
			QuestionAnswers questionAnswer = new QuestionAnswers();
			questionAnswer.setQuestion(questions[i]);
			user.getQustionsAndAnswers().add(questionAnswer);
		}
		userRepository.save(user);
		return user.getQustionsAndAnswers().get(0);
	}

}
