package uk.co.boombastech.http;

public enum Cookie {
	cookieName,
	anotherCookie;
	private final int defaultMaxAge;
	private final boolean defaultSecured;

	Cookie() {
		defaultMaxAge = -1;
		defaultSecured = true;
	}

	Cookie(int defaultMaxAge, boolean defaultSecured) {
		this.defaultMaxAge = defaultMaxAge;
		this.defaultSecured = defaultSecured;
	}

	public int getDefaultMaxAge() {
		return defaultMaxAge;
	}

	public boolean isDefaultSecured() {
		return defaultSecured;
	}
}