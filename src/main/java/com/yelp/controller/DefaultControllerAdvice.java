package com.yelp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.yelp.exception.NoYelpReviewFoundException;
import com.yelp.exception.YelpReviewDataException;

@ControllerAdvice
public class DefaultControllerAdvice extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(NoYelpReviewFoundException.class)
	public ResponseEntity<String> handleNoYelpReviewFoundException(NoYelpReviewFoundException ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
				.body("No data found");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(YelpReviewDataException.class)
	public ResponseEntity<String> handleApplicationException(YelpReviewDataException ex) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
				.body(ex.getMessage());
	}

    
    
}
