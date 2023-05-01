package Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="City")
public class City {
    @Column(name="city_name",length =  60, nullable = false)
    private String name;
    @Id
    @Column(name="city_id",nullable = false)
    private int id;

    @OneToMany (mappedBy =  "city", cascade = CascadeType.ALL, orphanRemoval = true, fetch =  FetchType.LAZY)
    private List<Employee> employeeList;

    public City() {
    }

    public City(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public City(String name, int id, List <Employee> list) {
        this.name = name;
        this.id = id;
        this.employeeList=list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", id=" + id;
    }

}
