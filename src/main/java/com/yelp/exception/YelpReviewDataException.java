package com.yelp.exception;

public class YelpReviewDataException extends RuntimeException {
	
	
	private static final long serialVersionUID = 2570119523614685952L;

	public YelpReviewDataException(String message, Throwable cause) {
		super(message, cause);
	}

}
