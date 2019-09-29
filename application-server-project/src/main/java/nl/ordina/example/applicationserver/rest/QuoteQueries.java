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
	public Response getRandomQuote() {
		return Response.ok(quotes.getRandomQuote()).build();
	}
}
