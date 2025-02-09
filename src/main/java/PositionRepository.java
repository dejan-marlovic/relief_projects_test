import jakarta.persistence.*;
import java.util.List;

public class PositionRepository {
    private final EntityManager em;

    public PositionRepository(EntityManager em){
        this.em = em;

    }

    public void save(Position position){
        em.getTransaction().begin();
        em.persist(position);
        em.getTransaction().commit();
    }

    public List<Position> findAll(){
        return em.createQuery("SELECT p FROM Position p", Position.class)
                .getResultList();
    }

    public Position findByName(String positionName){
        return em.createQuery("SELECT p FROM Position p WHERE p.positionName = :positionName", Position.class)
                .setParameter("positionName", positionName)
                .getSingleResult();
    }

}
