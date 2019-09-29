package nl.ordina.example.applicationserver.domain;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Quotes {

    public Quote getRandomQuote() {
        long randomId = Double.valueOf(Math.random() * 100).longValue();

        Quote quote = new Quote();
        quote.setId(randomId);
        quote.setQuote("quote" + randomId);
        quote.setAuthor("author" + randomId);

        return quote;
    }
}
