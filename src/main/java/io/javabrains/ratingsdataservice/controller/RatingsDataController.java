package io.javabrains.ratingsdataservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.ratingsdataservice.model.MovieDBResource;
import io.javabrains.ratingsdataservice.model.RatingInfoResource;
import io.javabrains.ratingsdataservice.model.UserRatings;

@RestController
@RequestMapping("/ratings")
public class RatingsDataController {

	@LoadBalanced
	private RestTemplate restTemplate = new RestTemplate();

	@Value("${api.key}")
	String key;

	@RequestMapping("/{movieId}")
	public RatingInfoResource getRatings(@PathVariable("movieId") String movieId) {
		return new RatingInfoResource(movieId, 10);
	}

	@RequestMapping("user/{userId}")
	public UserRatings getUserRatings(@PathVariable("userId") String movieId) {

		Random rand = new Random();

		List<RatingInfoResource> ratingList = new ArrayList<RatingInfoResource>();

		for (int i = 0; i < 5; i++) {
			int mvId = rand.nextInt(200);
			System.out.println("mvId---->"+mvId);
			MovieDBResource dbResource = restTemplate.getForObject(
					"https://api.themoviedb.org/3/movie/" + mvId + "?api_key=" + key,
					MovieDBResource.class);
			ratingList.add(new RatingInfoResource(dbResource.getId(), dbResource.getPopularity()));
		}

		UserRatings userRatings = new UserRatings();
		userRatings.setRatingInfo(ratingList);
		return userRatings;
	}
}