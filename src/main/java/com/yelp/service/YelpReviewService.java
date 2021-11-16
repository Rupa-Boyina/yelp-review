package com.yelp.service;

import com.yelp.model.ReviewInfo;

public interface YelpReviewService {

	public ReviewInfo getReviewInfo(String restaurantId);
}
