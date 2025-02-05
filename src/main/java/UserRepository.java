import jakarta.persistence.*;

import java.util.List;

public class UserRepository {
    private final EntityManager em;

    /**
     * Injection via constructor
     * @param em injected EntityManager object?
     */
    public UserRepository(EntityManager em){
        this.em = em;
    }

    public void save(User user){
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    /**
     * uses java persistence query language JPQL to return list of user
     * objects from the database
     * @return list of user objects List<User>
     */
    public List<User> findAll(){
        return em.createQuery("SELECT u from User u", User.class)
                .getResultList();
    }

    public User findByEmail(String email){
        return em.createQuery("SELECT u FROM User u WHERE u.email = :email",User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

}
