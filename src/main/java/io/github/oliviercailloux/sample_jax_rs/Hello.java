package io.github.oliviercailloux.sample_jax_rs;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("hello")
public class Hello {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(Hello.class.getCanonicalName());

	@Inject
	private ServletContext context;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		LOGGER.info(
				String.format("Env values: %s, %s.", System.getenv("MY_ENV_VAR"), System.getenv("MY_SECOND_ENV_VAR")));
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
