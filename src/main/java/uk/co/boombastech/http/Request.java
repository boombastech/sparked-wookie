package uk.co.boombastech.http;

import java.util.List;
import java.util.Map;

public interface Request {
	List<String> getQueryParameter(Parameter parameter);
	Map<Parameter, List<String>> getAllQueryParameters();
}