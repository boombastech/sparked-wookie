package uk.co.boombastech.http;

public enum HttpStatus {
	OK(200);

	private final int statusCode;

	HttpStatus(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}
}