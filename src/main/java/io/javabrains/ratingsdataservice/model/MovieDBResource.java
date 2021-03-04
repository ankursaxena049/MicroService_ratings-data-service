package io.javabrains.ratingsdataservice.model;

public class MovieDBResource {

	private float popularity;
	private String id;
	String status_code;
	String status_message;

	public MovieDBResource(float popularity, String id, String status_code, String status_message) {
		super();
		this.popularity = popularity;
		this.id = id;
		this.status_code = status_code;
		this.status_message = status_message;
	}

	public MovieDBResource() {
	}

	public float getPopularity() {
		return popularity;
	}

	public void setPopularity(float popularity) {
		this.popularity = popularity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus_code() {
		return status_code;
	}

	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}

	public String getStatus_message() {
		return status_message;
	}

	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}

	@Override
	public String toString() {
		return "MovieDBResource [popularity=" + popularity + ", id=" + id + ", status_code=" + status_code
				+ ", status_message=" + status_message + "]";
	}

}
