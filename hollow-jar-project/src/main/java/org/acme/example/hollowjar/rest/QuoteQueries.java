package org.acme.example.hollowjar.rest;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/quotes")
@Produces(APPLICATION_JSON)
@ApplicationScoped
public class QuoteQueries {

    private Jsonb jsonb;

    @PostConstruct
    public void init() {
        this.jsonb = JsonbBuilder.create();
    }

    @Inject
    @RestClient
    private QuotesBackendClient quotesBackendClient;

    @GET
    @Path("/random/backend")
    @Retry
    @Fallback(fallbackMethod = "fallback")
    @Timeout(2000)
    public Response getRandomQuote() {
		return Response.ok(quotesBackendClient.getRandomQuoteFromBackend()).build();
    }

    private Response fallback() {
        return Response.status(400).entity(this.jsonb.toJson("Could not retrieve Quotes from the backend server")).build();
    }
}
