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
            //relief_projects is persistence unit name from persistence.xml
            emf = Persistence.createEntityManagerFactory("relief_projects");
            em = emf.createEntityManager();
            UserRepository userRepo = new UserRepository(em);

            Position position = em.find(Position.class, 1L); // Replace 1L with the correct position ID

            // Fetch the existing Employee from the database (assuming employee ID 1 exists)
            Employee employee = em.find(Employee.class, 1L); // Replace 1L with th


            if (position != null && employee != null) {
                // Create a new User instance and associate it with the Employee
                User user = new User();
                user.setUsername("johndoe");
                user.setPasswordHash(User.hashPassword("hashedPassword123"));
                user.setEmail("johndoe@example.com");
                user.setEmployee(employee); // Link the user to the employee (foreign key relation)

                userRepo.save(user);

                System.out.println("User successfully inserted!");
            } else {
                System.out.println("Position or Employee not found!");
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }

}
