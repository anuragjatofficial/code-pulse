package com.codePlus.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CodePulseExceptionHandler {

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorDetails> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception,
			WebRequest we) {
		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(LocalDateTime.now(), exception.getMessage(), we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> handleNoHandlerFoundException(NoHandlerFoundException exception,
			WebRequest we) {
		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(LocalDateTime.now(), exception.getMessage(), we.getDescription(false)),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceAccessException.class)
	public ResponseEntity<ErrorDetails> handleResourceAccessException(
			ResourceAccessException exceResourceAccessException, WebRequest we) {
		return new ResponseEntity<ErrorDetails>(new ErrorDetails(LocalDateTime.now(),
				" ChatGpt server acces timed out please try again ", we.getDescription(false)),
				HttpStatus.TOO_MANY_REQUESTS);
	}

	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ErrorDetails> handleInvalidDataException(InvalidDataException invalidDataException,
			WebRequest we) {
		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(LocalDateTime.now(), invalidDataException.getMessage(), we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException userNotFoundException,
			WebRequest we) {
		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(LocalDateTime.now(), userNotFoundException.getMessage(), we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorDetails> handleRuntimeException(RuntimeException exception,
			WebRequest we) {
		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(LocalDateTime.now(), exception.getMessage(), we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleException(Exception exception,
			WebRequest we) {
		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(LocalDateTime.now(), exception.getMessage(), we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}
}
