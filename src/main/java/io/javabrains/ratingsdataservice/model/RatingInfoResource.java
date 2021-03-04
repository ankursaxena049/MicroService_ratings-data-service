package io.javabrains.ratingsdataservice.model;

public class RatingInfoResource {

	private String movieId;
	private float rating;

	public RatingInfoResource(String movieId, float rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}
