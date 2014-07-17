package uk.co.boombastech.routing;

import uk.co.boombastech.homepage.HomepageRoute;

public enum UriFor {
	homepage("/", HomepageRoute.class);

	private final String path;
	private final Class<? extends Route> route;

	UriFor(String path, Class<? extends Route> route) {
		this.path = path;
		this.route = route;
	}

	void registerPath(WebApplication webApplication) {
		webApplication.registerPath(path, route);
	}
}