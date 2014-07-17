package uk.co.boombastech.routing;

import uk.co.boombastech.http.Request;
import uk.co.boombastech.http.Response;
import uk.co.boombastech.http.SparkRequest;
import uk.co.boombastech.http.SparkResponse;

public abstract class Route implements spark.Route {

	@Override
	public Object handle(spark.Request request, spark.Response response) {
		response.cookie("cookieName", "hey I'm a cookie");
		return handle(new SparkRequest(request), new SparkResponse(response));
	}

	public abstract Object handle(Request request, Response response);
}