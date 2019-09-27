package nl.ordina.example.applicationserver.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class Quotes {

    @PersistenceContext(unitName = "quote_dbPU")
    private EntityManager entityManager;

    public Quote getRandonQuote() {
        long randomId = Double.valueOf(Math.random() * getQuoteAmount()).longValue();

        return this.entityManager.find(Quote.class, randomId);
    }

    private Long getQuoteAmount() {
        return (Long)this.entityManager.createNativeQuery("SELECT count(*) FROM quote").getSingleResult();
    }
}
