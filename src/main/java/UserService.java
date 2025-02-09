import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;


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
            //relief_projects is persistence unit name that we defined in persistence.xml
            //we use pre-defined persistence unit to create entity manager factory
            emf = Persistence.createEntityManagerFactory("relief_projects");

            //we crate entity manager from entity manager factory object
            em = emf.createEntityManager();

            //we inject em object into our repositories
            //so we can fetch data as object or store it in the database
            UserRepository userRepo = new UserRepository(em);
            PositionRepository positionRepo = new PositionRepository(em);
            EmployeeRepository employeeRepo = new EmployeeRepository(em);

            Position position = positionRepo.findByName("Project Assistant");

            Position newPosition = new Position();
            newPosition.setPositionName("Test new Position");
            positionRepo.save(newPosition);

            // Fetch the existing Employee from the database (assuming employee ID 1 exists)
            Employee employee = employeeRepo.findByEmployeeId(1);

            Employee newEmployee = new Employee();

            newEmployee.setFirstName("Test test");
            newEmployee.setLastName("Testy");
            newEmployee.setPosition(position);

            employeeRepo.save(newEmployee);

            if (position != null && employee != null) {
                // Create a new User instance and associate it with the Employee
                User user = new User();
                user.setUsername("johndoe");
                user.setPasswordHash(User.hashPassword("hashedPassword123"));
                user.setEmail("johndoe@example.com");
                user.setEmployee(employee); // Link the user to the employee (foreign key relation)
                user.setCreatedAt(LocalDateTime.now());
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
