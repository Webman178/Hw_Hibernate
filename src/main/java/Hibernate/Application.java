package Hibernate;

import java.util.ArrayList;
import java.util.List;
import Hibernate.DAO.*;

public class Application {
    public static void printList(List list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        City city = new City("Ижевск",100, list);
        Employee employee1 = new Employee("Astafiev","Sergey","male",22, city);
        list.add(employee1);
        list.add(new Employee("Solovev","Pavel","male",21,city));
        list.add(new Employee("Soloveva","Ira","female",21,city));

        CityDAO cityDAO = new CityDAOImpl();
        EmployeeDAO employeeDAO = new  EmplyeeDAOImpl();
        cityDAO.addCity(city);
        System.out.println("Добавили город :"+city);
        printList(cityDAO.getAllCity());
        printList(employeeDAO.getAllEmployees());

        Employee employee2 = new Employee(employee1.getId(), "newEmployee","newEmployee","male",23,city);
        city.getEmployeeList().set(0,employee2);
        cityDAO.update(city);
        System.out.println("Заменили сотрудника");
        printList(employeeDAO.getAllEmployees());

        System.out.println("После удаления города");
        cityDAO.delete(city);
        printList(cityDAO.getAllCity());
        printList(employeeDAO.getAllEmployees());



    }
}
