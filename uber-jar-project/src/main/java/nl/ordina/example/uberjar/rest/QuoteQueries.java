package nl.ordina.example.uberjar.rest;

import org.eclipse.microprofile.rest.client.inject.RestClient;

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
	@RestClient
	private QuotesMicroserviceClient quotesMicroserviceClient;

	@GET
	@Path("/random/microservice")
	public Response getRandomQuote() {
		return Response.ok(quotesMicroserviceClient.getRandomQuoteFromMicroservice()).build();
	}
}
