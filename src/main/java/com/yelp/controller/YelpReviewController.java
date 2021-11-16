package com.yelp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yelp.model.ReviewInfo;

//@RestController
//@RequestMapping("/yelp-review")
public interface YelpReviewController {
	
	//@GetMapping("/getReview")
	//@ResponseBody
	public ReviewInfo getReviewInfo(String restaurantId);

}
