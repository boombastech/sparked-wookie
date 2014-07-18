package uk.co.boombastech.http;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static uk.co.boombastech.http.Cookie.cookieName;
import static uk.co.boombastech.http.HttpStatus.OK;

@RunWith(MockitoJUnitRunner.class)
public class SparkResponseTest {

	private Response response;

	@Mock
	private spark.Response wrappedResponse;

	@Before
	public void setUp() throws Exception {
		response = new SparkResponse(wrappedResponse);
	}

	@Test
	public void shouldSetCookieOnResponse() throws Exception {
		response.setCookie(cookieName, "some value");

		verify(wrappedResponse).cookie(cookieName.name(), "some value", cookieName.getDefaultMaxAge(), cookieName.isDefaultSecured());
	}

	@Test
	public void shouldSetCookieWithMaxAge() throws Exception {
		response.setCookie(cookieName, "some value", 123);

		verify(wrappedResponse).cookie(cookieName.name(), "some value", 123, cookieName.isDefaultSecured());
	}

	@Test
	public void shouldSetCookieWithMaxAgeAndSecuredSet() throws Exception {
		response.setCookie(cookieName, "some value", 123, true);

		verify(wrappedResponse).cookie(cookieName.name(), "some value", 123, true);
	}

	@Test
	public void shouldSetHttpStatusOnResponse() throws Exception {
		response.setStatus(OK);

		verify(wrappedResponse).status(OK.getStatusCode());
	}
}