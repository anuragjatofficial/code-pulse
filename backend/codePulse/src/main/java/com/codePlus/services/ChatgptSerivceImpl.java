package com.codePlus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codePlus.exceptions.UserNotFoundException;
import com.codePlus.model.ChatgptResponse;
import com.codePlus.model.Prompt;
import com.codePlus.model.QuestionAnswers;
import com.codePlus.model.User;
import com.codePlus.repository.ChatgptApiRepository;
import com.codePlus.repository.UserRepository;

import io.swagger.v3.oas.models.media.MediaType;

@Service
public class ChatgptSerivceImpl implements ChatgptService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ChatgptApiRepository chatApi;

	@Autowired
	private RestTemplate api;
	

	private final String url="https://api.openai.com/v1/chat/completions";
	private final String model="gpt-3.5-turbo";
	
	@Override
	public String start(String userName) {
		// TODO Auto-generated method stub
		
		// finding username 
		
		User u = userRepo.findByUserName(userName).orElse(null);
		String type = u.getInterviewType();
		
		if(u==null) {
			throw new UserNotFoundException("Invalid Credentials");
		}
		else {
			
			org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
			
			headers.add("Authorization", "Bearer "+chatApi.getApiKey());
			headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
			
			String requestBody= "{\r\n"
					+ "  \"model\": \"gpt-3.5-turbo\",\r\n"
					+ "  \"messages\": [\r\n"
					+ "    {\r\n"
					+ "      \"role\": \"user\",\r\n"
					+ "      \"content\": \"give me 10 interview questions for "+type+" interview\"\r\n"
					+ "    }\r\n"
					+ "  ]\r\n"
					+ "}\r\n";
			
			HttpEntity<String> request = new HttpEntity<>(requestBody,headers);
			
			 ChatgptResponse r =  api.postForObject(url, request, ChatgptResponse.class);
			
			return r.getChoices().get(0).getMessage().getContent();
		}
		
	}

	@Override
	public QuestionAnswers feedBack(List<QuestionAnswers> Q) {
		// TODO Auto-generated method stub
		
		String request="";
		
		for(QuestionAnswers A: Q) {
			
			String request_temp = "This is Question "+A.getQuestion()+" And This is Answer "+A.getAnswer();
			request+= request_temp.replaceAll("\"", "");
		}
		
		request+="`read all the question and answers and provide feedback basis on communication skills, technical skils, Conceptual Understanding and interview skills on a scale of 100 for example response should look like 'Communication Skills: 60/100 technical skills: 60/100 Interview Skills: 60/100, Conceptual Understanding: 60/100 in key value pair and no need to provide feedback for each question '  ";
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		
		headers.add("Authorization", "Bearer "+chatApi.getApiKey());
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		
		String requestBody= "{\r\n"
				+ "  \"model\": \"gpt-3.5-turbo\",\r\n"
				+ "  \"messages\": [\r\n"
				+ "    {\r\n"
				+ "      \"role\": \"user\",\r\n"
				+ "      \"content\": \""+request+" \"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}\r\n";
		
		
		HttpEntity<String> request1 = new HttpEntity<>(requestBody,headers);
		
		 ChatgptResponse r =  api.postForObject(url, request1, ChatgptResponse.class);
		 
		
		 QuestionAnswers response_client = new QuestionAnswers();
		 
		 response_client.setQuestion("Interview Completed, I have Provided the Feedback");
		 response_client.setAnswer(r.getChoices().get(0).getMessage().getContent());
		 
		return response_client;
	}
	

}
