import jakarta.persistence.*;
import java.util.List;


public class CurrencyRepository {
    private final EntityManager em;

    /**
     * Injection via constructor
     * @param em injected EntityManager object
     * em objects are used for saving and fetching data
     */
    public CurrencyRepository(EntityManager em) {
        this.em = em;
    }


    public List<Currency> findAll(){
        return em.createQuery("SELECT c FROM Currency c", Currency.class)
                .getResultList();
    }

    public Currency findByName(String name){
        return em.createQuery("SELECT c FROM Currency c WHERE c.name = :name", Currency.class)
                .setParameter("name",name)
                .getSingleResult();
    }

    public void save(Currency currency){
        em.getTransaction().begin();
        em.persist(currency);
        em.getTransaction().commit();
    }
}
