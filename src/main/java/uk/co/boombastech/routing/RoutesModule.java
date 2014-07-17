package uk.co.boombastech.routing;

import com.google.inject.AbstractModule;
import uk.co.boombastech.homepage.HomepageRoute;

public class RoutesModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(HomepageRoute.class);
	}
}