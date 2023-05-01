package Hibernate.DAO;

import Hibernate.Employee;


import java.util.List;

public interface EmployeeDAO {
    public int addEmployee(Employee employee);
    public Employee getEmployeeByID(int id);
    public List<Employee> getAllEmployees();
    public void updateEmployee(Employee employee);
    public void deleteEmployee(Employee employee);

    //public Integer getIDbyEmployee(Employee employee);
}
