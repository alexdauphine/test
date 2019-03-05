package io.github.oliviercailloux.sample_jax_rs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class IntegrationTest {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(IntegrationTest.class.getCanonicalName());

	@Test
	public void testServlet() throws Exception {
		assertEquals("Hello, world.", new Hello().sayHello());
	}

}
