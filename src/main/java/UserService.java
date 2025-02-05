import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class UserService {

    public static void main(String[] args) {

        /*
         jakarta.persistence.Persistence class is connected to the persistence.xml file.
         It is used to create an EntityManagerFactory,
         which loads the persistence unit configuration from the persistence.xml file.

         How It Works:

         The persistence.xml file is typically located in the META-INF folder of
         the src/main/resources directory in a JPA project. It contains
         details about the persistence unit, such as the database connection,
         JPA provider, and entity classes.

         */
        EntityManagerFactory emf = null;

        EntityManager em = null;

        try {
            //this is persistence unit name
            emf = Persistence.createEntityManagerFactory("relief_projects");
            em = emf.createEntityManager();
            UserRepository userRepo = new UserRepository(em);
            User user = new User("Dejan", "password12345", "dmarlovic83@gmail.com");
            userRepo.save(user);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(em != null){
                em.close();
            }
            if(emf != null){
                emf.close();
            }
        }
    }

}
