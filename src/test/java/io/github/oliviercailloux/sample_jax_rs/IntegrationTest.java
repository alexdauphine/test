package io.github.oliviercailloux.sample_jax_rs;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class IntegrationTest {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(IntegrationTest.class.getCanonicalName());

	@Deployment(testable = false)
	public static WebArchive createDeployment() {
		final WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war")
				.addPackage(IntegrationTest.class.getPackage());
		return war;
	}

	@ArquillianResource
	private URL baseURL;

	@Test
	public void testServlet() throws Exception {
		final Client client = ClientBuilder.newClient();
		final WebTarget target = client.target(baseURL.toString()).path("/v1/hello");
		LOGGER.info(target.getUri().toString());
		final String result = target.request(MediaType.TEXT_PLAIN).get(String.class);
		assertEquals("Hello, world.", result);
		client.close();
	}

}
