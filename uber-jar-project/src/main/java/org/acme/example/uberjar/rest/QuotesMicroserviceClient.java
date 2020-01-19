package org.acme.example.uberjar.rest;

import org.acme.example.uberjar.domain.Quote;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/quotes")
@Produces(APPLICATION_JSON)
@RegisterRestClient
public interface QuotesMicroserviceClient {

    @GET
    @Path("/random/backend")
    Quote getRandomQuoteFromMicroservice();
}
