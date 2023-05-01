package Hibernate.DAO;

import Hibernate.Employee;
import Hibernate.MyConnection;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EmplyeeDAOImpl implements EmployeeDAO{
    @Override
    public int addEmployee(Employee employee) {
        int newId = -1;
        try (MyConnection connection = new MyConnection()) {
            EntityManager entityManager = connection.getEntityManager();
            entityManager.getTransaction().begin();

            entityManager.persist(employee);

            entityManager.getTransaction().commit();
            newId = employee.getId();
        }
        return newId;
    }

    @Override
    public Employee getEmployeeByID(int id) {
        Employee employee = null;
        try (MyConnection connection = new MyConnection()) {
            EntityManager entityManager = connection.getEntityManager();
            entityManager.getTransaction().begin();

            employee = entityManager.find(Employee.class, id);

            entityManager.getTransaction().commit();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try (MyConnection connection = new MyConnection()) {
            EntityManager entityManager =  connection.getEntityManager();
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("SELECT e FROM Employee e");
            list=query.getResultList();

            entityManager.getTransaction().commit();
        }
        return list;
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (MyConnection connection = new MyConnection()) {
            EntityManager entityManager = connection.getEntityManager();
            entityManager.getTransaction().begin();

            entityManager.merge(employee);

            entityManager.getTransaction().commit();
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try (MyConnection connection = new MyConnection()) {
            EntityManager entityManager = connection.getEntityManager();
            entityManager.getTransaction().begin();

            entityManager.remove(entityManager.merge(employee));

            entityManager.getTransaction().commit();
        }
    }
}
