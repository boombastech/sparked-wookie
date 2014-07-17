package uk.co.boombastech.http;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class ParameterMapBuilder {

	private final Map<String, String[]> map;

	public ParameterMapBuilder() {
		map = newHashMap();
	}

	public ParameterMapBuilder withParameter(Parameter parameter, String... values) {
		map.put(parameter.name(), values);
		return this;
	}

	public Map<String, String[]> build() {
		return map;
	}
}