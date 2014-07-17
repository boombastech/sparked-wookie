package uk.co.boombastech.homepage;

import uk.co.boombastech.http.Cookie;
import uk.co.boombastech.http.Parameter;
import uk.co.boombastech.http.Request;
import uk.co.boombastech.http.Response;
import uk.co.boombastech.routing.Route;

import java.util.List;
import java.util.Map;

public class HomepageRoute extends Route {

	@Override
	public Object handle(Request request, Response response) {
		Map<Parameter,List<String>> allQueryParameters = request.getAllQueryParameters();
		request.getCookie(Cookie.cookieName);

		return allQueryParameters;
	}
}