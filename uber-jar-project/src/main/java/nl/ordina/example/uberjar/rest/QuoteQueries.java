package nl.ordina.example.uberjar.rest;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import nl.ordina.example.uberjar.domain.Quote;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

@Path("/quotes")
@Produces(APPLICATION_JSON)
@ApplicationScoped
@Named("quoteQueries")
public class QuoteQueries {

	private Jsonb jsonb;

	@PostConstruct
	public void init() {
		this.jsonb = JsonbBuilder.create();
	}

	@Inject
	@RestClient
	private QuotesMicroserviceClient quotesMicroserviceClient;

	@GET
	@Path("/random/microservice")
	@Fallback(fallbackMethod = "fallback")
	public Response getRandomQuote() {
		return Response.ok(this.quotesMicroserviceClient.getRandomQuoteFromMicroservice()).build();
	}

	public List<Quote> getRandomQuotes() {
		return List.of(quotesMicroserviceClient.getRandomQuoteFromMicroservice());
	}
	
	private Response fallback() {
		return Response.status(400).entity(this.jsonb.toJson("Could not retrieve Quotes from the intermediate server")).build();
	}
}
