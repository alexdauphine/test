package io.github.oliviercailloux.sample_jax_rs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("v1")
public class MyJaxRsApp extends Application {
	/** Empty. The server will then discover all resource classes automatically. */
}
