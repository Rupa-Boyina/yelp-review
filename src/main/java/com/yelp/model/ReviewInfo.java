package com.yelp.model;

import java.util.List;

import lombok.Data;

@Data
public class ReviewInfo {
	
	public List<Review> reviews;
    public int total;
    public List<String> possible_languages;

}
