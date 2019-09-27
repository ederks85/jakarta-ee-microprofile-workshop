package nl.ordina.example.hollowjar.rest;

import nl.ordina.example.hollowjar.domain.Quote;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/quotes")
@Produces(APPLICATION_JSON)
@RegisterRestClient
public interface QuotesBackendClient {

    @GET
    @Path("/random")
    Quote getRandomQuoteFromBackend();
}
