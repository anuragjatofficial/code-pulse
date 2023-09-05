package com.codePlus.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codePlus.model.QuestionAnswers;
import com.codePlus.model.User;
import com.codePlus.repository.AnswerRepository;
import com.codePlus.repository.QuestionRepository;
import com.codePlus.services.ChatgptService;
import com.codePlus.services.UserService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("*")
@Slf4j
public class InterviewControllor {

	@Autowired
	private UserService userService;

	@Autowired
	private ChatgptService chatgptService;

	@GetMapping("/hello")
	public ResponseEntity<String> helloMapper() {
		log.info("Request Type: [GET],\t Endpoint: \"/hello\",\t"+ "TimeStamp : " + LocalDateTime.now());
		return new ResponseEntity<String>("Hello", HttpStatus.ACCEPTED);
	}

	@PostMapping("/users")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
		log.info("Request Type: [POST],\t Endpoint: \"/users\",\t"+ "TimeStamp : " + LocalDateTime.now());
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/start")
	public ResponseEntity<QuestionAnswers> start(@RequestParam("username") String userName) {
		log.info("Request Type: [GET],\t Endpoint: \"/start\",\t"+ "TimeStamp : " + LocalDateTime.now());
		String c = chatgptService.start(userName);
		String[] questions = c.trim().split("\n");
		QuestionAnswers res = userService.addQuestions(questions, userName);
		return new ResponseEntity<QuestionAnswers>(res, HttpStatus.ACCEPTED);
	}

	@PostMapping("/users/{username}/chat")
	public ResponseEntity<QuestionAnswers> addChat(@RequestBody QuestionAnswers questionAnswers , @PathVariable String username){
		log.info("Request Type: [POST],\t Endpoint: \"/users/"+username+"/chat\",\t"+ "TimeStamp : " + LocalDateTime.now());
		return new ResponseEntity<QuestionAnswers>(userService.addChat(questionAnswers,username),HttpStatus.CREATED);
	}
	
}
