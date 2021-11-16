package com.yelp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yelp.exception.NoYelpReviewFoundException;
import com.yelp.model.ReviewInfo;
import com.yelp.service.YelpReviewService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/yelp-review")
@Slf4j
public class DefaultYelpReviewController implements YelpReviewController {
	
	@Autowired
	private YelpReviewService yelpReviewService;

	@GetMapping("/getReview/{restaurantId}")
	@ResponseBody
	@Override
	public ReviewInfo getReviewInfo(@PathVariable String restaurantId) {
		
		log.info("restaurantId : {} "+ restaurantId);
		
		ReviewInfo reviewInfo = yelpReviewService.getReviewInfo(restaurantId);
		
		if(null == reviewInfo) {
			throw new NoYelpReviewFoundException();
		}
		return reviewInfo;
	}

}
