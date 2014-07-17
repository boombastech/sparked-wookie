package uk.co.boombastech.http;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import spark.QueryParamsMap;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static uk.co.boombastech.http.Parameter.asdf;
import static uk.co.boombastech.http.Parameter.fda;

@RunWith(MockitoJUnitRunner.class)
public class SparkRequestTest {

	private Request request;
	@Mock
	private spark.Request wrappedRequest;
	@Mock
	private QueryParamsMap queryParamsMap;

	private final String[] singleValueArray = { "value1" };
	private final String[] multipleValueArray = { "value1", "value2" };
	private Map<String, String[]> parameterMapWithSingleParameter;
	private Map<String, String[]> parameterMapWithMultipleParameters;
	private Map<String, String[]> emptyParameterMap;

	@Before
	public void setUp() throws Exception {
		request = new SparkRequest(wrappedRequest);
		parameterMapWithSingleParameter = new ParameterMapBuilder().withParameter(asdf, "value1").build();
		parameterMapWithMultipleParameters = new ParameterMapBuilder().withParameter(asdf, "value1").withParameter(fda, "value1", "value2").build();
		emptyParameterMap = emptyMap();
	}

	@Test
	public void shouldReturnListOfQueryParameterValuesWhenPresentOnRequest() throws Exception {
		when(wrappedRequest.queryMap("asdf")).thenReturn(queryParamsMap);
		when(queryParamsMap.hasValue()).thenReturn(true);
		when(queryParamsMap.values()).thenReturn(singleValueArray);

		List<String> queryParameters = request.getQueryParameter(asdf);

		assertThat(queryParameters).hasSize(1);
		assertThat(queryParameters).contains("value1");
	}

	@Test
	public void shouldReturnListOfMultipleQueryParameterValuesWhenPresentOnRequest() throws Exception {
		when(wrappedRequest.queryMap("asdf")).thenReturn(queryParamsMap);
		when(queryParamsMap.hasValue()).thenReturn(true);
		when(queryParamsMap.values()).thenReturn(multipleValueArray);

		List<String> queryParameters = request.getQueryParameter(asdf);

		assertThat(queryParameters).hasSize(2);
		assertThat(queryParameters).contains("value1", "value2");
	}

	@Test
	public void shouldReturnEmptyListWhenTheSpecifiedQueryParameterIsNotContainedOnTheRequest() throws Exception {
		when(wrappedRequest.queryMap("asdf")).thenReturn(queryParamsMap);
		when(queryParamsMap.hasValue()).thenReturn(false);

		List<String> queryParameters = request.getQueryParameter(asdf);

		assertThat(queryParameters).hasSize(0);
	}

	@Test
		 public void shouldReturnMapOfSingleParameterAndValueForRequestWithOnlyOneQueryParameter() throws Exception {
		when(wrappedRequest.queryMap()).thenReturn(queryParamsMap);
		when(queryParamsMap.toMap()).thenReturn(parameterMapWithSingleParameter);

		Map<Parameter,List<String>> allQueryParameters = request.getAllQueryParameters();

		assertThat(allQueryParameters).hasSize(1);
		assertThat(allQueryParameters.get(asdf)).hasSize(1);
		assertThat(allQueryParameters.get(asdf)).containsOnly("value1");
	}

	@Test
	public void shouldReturnMapOfParametersAndValuesForRequestWithOnlyMultipleQueryParameters() throws Exception {
		when(wrappedRequest.queryMap()).thenReturn(queryParamsMap);
		when(queryParamsMap.toMap()).thenReturn(parameterMapWithMultipleParameters);

		Map<Parameter,List<String>> allQueryParameters = request.getAllQueryParameters();

		assertThat(allQueryParameters).hasSize(2);
		assertThat(allQueryParameters.get(asdf)).hasSize(1);
		assertThat(allQueryParameters.get(asdf)).containsOnly("value1");
		assertThat(allQueryParameters.get(fda)).hasSize(2);
		assertThat(allQueryParameters.get(fda)).containsOnly("value1", "value2");
	}

	@Test
	public void shouldReturnEmptyMapForRequestWithNoQueryParameters() throws Exception {
		when(wrappedRequest.queryMap()).thenReturn(queryParamsMap);
		when(queryParamsMap.toMap()).thenReturn(emptyParameterMap);

		Map<Parameter,List<String>> allQueryParameters = request.getAllQueryParameters();

		assertThat(allQueryParameters).hasSize(0);
	}
}