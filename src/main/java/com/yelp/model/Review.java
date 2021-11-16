package com.yelp.model;

import lombok.Data;

@Data
public class Review {

	public String id;
    public String url;
    public String text;
    public int rating;
    public String time_created;
    public User user;
	
}
