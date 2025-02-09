import jakarta.persistence.*;
import java.util.List;

public class EmployeeRepository {
    private final EntityManager em;

    public EmployeeRepository(EntityManager em){
        this.em = em;
    }

    public void save(Employee employee){
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
    }

    public List<Employee> findAll(){
        return em.createQuery("SELECT  e FROM  Employee e", Employee.class)
                .getResultList();
    }

    public Employee findByEmployeeId(int id){
        return em.createQuery("SELECT e FROM Employee e WHERE e.id = :id", Employee.class ).
                setParameter("id", id).getSingleResult();


    }

}
