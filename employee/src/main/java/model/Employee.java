package model;

import java.util.Date;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String sex;
    private int salary;


    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, Date birthDate, String sex, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDate;
        this.sex = sex;
        this.salary = salary;

    }

    public Employee(String firstName, String lastName, Date birthDate, String sex, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDate;
        this.sex = sex;
        this.salary = salary;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


}
