package uk.co.boombastech.http;

public class SparkResponse implements Response {

	private final spark.Response wrappedResponse;

	public SparkResponse(spark.Response wrappedResponse) {
		this.wrappedResponse = wrappedResponse;
	}

	@Override
	public void setCookie(Cookie cookie, String value) {
		wrappedResponse.cookie(cookie.name(), value, cookie.getDefaultMaxAge(), cookie.isDefaultSecured());
	}

	@Override
	public void setCookie(Cookie cookie, String value, int maxAge) {
		wrappedResponse.cookie(cookie.name(), value, maxAge, cookie.isDefaultSecured());
	}

	@Override
	public void setCookie(Cookie cookie, String value, int maxAge, boolean secured) {
		wrappedResponse.cookie(cookie.name(), value, maxAge, secured);
	}
}