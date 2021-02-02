package demo.beans;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author imnot
 */
@Component("user")
public class User extends BasicBean{
    private String name;
    private int age;
    private double salary;
    private Date birthday;
    private String address;

    public User() {
    }

    public User(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public User setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }
}
