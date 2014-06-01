package org.mockito.configuration;

import org.mockito.internal.stubbing.defaultanswers.ReturnsSmartNulls;
import org.mockito.stubbing.Answer;

public class MockitoConfiguration extends DefaultMockitoConfiguration {

	public Answer<Object> getDefaultAnswer() {
		return new ReturnsSmartNulls();
	}

}