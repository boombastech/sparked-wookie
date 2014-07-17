package uk.co.boombastech.http;

public class SparkResponse implements Response {

	private final spark.Response wrappedResponse;

	public SparkResponse(spark.Response wrappedResponse) {
		this.wrappedResponse = wrappedResponse;
	}
}