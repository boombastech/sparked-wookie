package uk.co.boombastech.http;

public interface Response {
	void setCookie(Cookie cookie, String value);
	void setCookie(Cookie cookie, String value, int maxAge);
	void setCookie(Cookie cookie, String value, int maxAge, boolean secured);

	void setStatus(HttpStatus status);
}