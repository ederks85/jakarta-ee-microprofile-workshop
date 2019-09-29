package nl.ordina.example.hollowjar.rest;

import nl.ordina.example.hollowjar.domain.Quote;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/quotes")
@Produces(APPLICATION_JSON)
@ApplicationScoped
public class QuoteQueries {

    @Inject
    @RestClient
    private QuotesBackendClient quotesBackendClient;

    @GET
    @Path("/random/backend")
    public Quote getRandomQuote() {
//		return Response.ok(quotesBackendClient.getRandomQuoteFromBackend()).build();
        Client client = ClientBuilder.newClient();
        Quote quote = client.target("http://application-server-project:8080/application-server-project/rest/quotes/random")
                .request(MediaType.APPLICATION_JSON)
                .get(Quote.class);
        quote.setAuthor("Intermediary service");
        return quote;
    }
}
