package uk.co.boombastech.routing;

import com.google.inject.Injector;
import spark.Spark;

import static com.google.inject.Guice.createInjector;

public class WebApplication {
	private Injector injector;

	public void registerPath(String path, Class<? extends Route> route) {
		Spark.get(path, injector.getInstance(route));
	}

	public static void main(String[] args) {
		new WebApplication();
	}

	public WebApplication() {
		injector = createInjector(new RoutesModule());

		for (UriFor uriFor : UriFor.values()) {
			uriFor.registerPath(this);
		}
	}
}