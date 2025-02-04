import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserService {
    public static void main(String[] args){

        EntityManagerFactory emf = null;

        try{
            emf = Persistence.createEntityManagerFactory("relief_projects");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //////////////////////////////////
        User user = new User("Dejan Marlovic", "dmarlovic83@gmail.com");

        em.persist(user);
        em.getTransaction().commit();
        em.close();
        //////////////////////////////////

    }

}
