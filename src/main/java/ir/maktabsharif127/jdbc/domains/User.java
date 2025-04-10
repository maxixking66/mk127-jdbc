package ir.maktabsharif127.jdbc.domains;

import ir.maktabsharif127.jdbc.domains.base.BaseEntity;

public class User extends BaseEntity<Integer> {


    private String firstName;

    private String lastName;

    private Integer age;

    private String username;

    public User() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + getId() +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", age=" + age +
               ", username='" + username + '\'' +
               '}';
    }
}
