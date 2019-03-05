package io.github.oliviercailloux.sample_jax_rs;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class Hello {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(Hello.class.getCanonicalName());

	@Inject
	private ServletContext context;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		if (context == null) {
			LOGGER.warning("Context is null.");
		} else {
			LOGGER.info(String.format("Running on version: %d.%d.", context.getEffectiveMajorVersion(),
					context.getEffectiveMinorVersion()));
		}
		return justSayHello();
	}

	String justSayHello() {
		return "Hello, world.";
	}
}
