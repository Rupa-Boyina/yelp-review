package com.yelp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yelp.exception.YelpReviewDataException;
import com.yelp.model.ReviewInfo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultYelpReviewService implements YelpReviewService {
	
	@Value("${yelp.url}")
	private String yelpUrl;
	
	@Value("${yelp.apiKey}")
	private String yelpApiKey;

	@Override
	public ReviewInfo getReviewInfo(String restaurantId) {
		
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			httpHeaders.add("Authorization", "Bearer " + yelpApiKey);
			
			HttpEntity<ReviewInfo> httpEntity = new HttpEntity<ReviewInfo>(httpHeaders);
			
			String url = yelpUrl.concat(restaurantId).concat("/reviews");
			
			ResponseEntity<ReviewInfo> result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, ReviewInfo.class);
			log.info("result : {} "+ result);
			return result.getBody();
			
		} catch (Exception e) {
			log.error("An exception occured while calling yelp api", e);
			throw new YelpReviewDataException("An exception occured while calling yelp api", e);
		}
		
		
	}

}
