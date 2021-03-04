package io.javabrains.ratingsdataservice.model;

import java.util.List;

public class UserRatings {
	
	private List<RatingInfoResource> ratingInfo;

	public List<RatingInfoResource> getRatingInfo() {
		return ratingInfo;
	}

	public void setRatingInfo(List<RatingInfoResource> ratingInfo) {
		this.ratingInfo = ratingInfo;
	}
}
