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
}
