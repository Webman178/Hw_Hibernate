package Hibernate;
import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, String gender, int age, City city) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public Employee(String firstName, String lastName, String gender, int age, City city) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="last_name", length = 50, nullable = false)
    private String lastName;
    @Column(name="first_name", length = 50, nullable = false)
    private String firstName;
    @Column(length = 6, nullable = false)
    private String gender;
    @Column(nullable = false)
    private int age;
    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;

    @Override
    public String toString() {
        return id + " " + firstName + " " + lastName + " " + gender + " " + age + " " + city.getName();
    }
}

