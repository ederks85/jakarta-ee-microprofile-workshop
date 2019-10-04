package nl.ordina.example.applicationserver.rest;

import nl.ordina.example.applicationserver.domain.Quotes;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/quotes")
@Produces(APPLICATION_JSON)
@ApplicationScoped
public class QuoteQueries {

	@Inject
	private Quotes quotes;

	@GET
	@Path("/random")
	public Response getRandomQuote() throws Exception {
		// Simulate flaky behaviour
		long randomId = Double.valueOf(Math.random() * 10d).longValue();

		if (randomId >= 0l && randomId < 4l) {
			throw new RuntimeException("Random exception from Quote backend");
		} else if (randomId >= 4l && randomId < 6l) {
			Thread.sleep(10000);
		}
		return Response.ok(quotes.getRandomQuote()).build();
	}
}
