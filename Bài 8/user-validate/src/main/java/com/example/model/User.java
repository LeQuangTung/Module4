package com.example.model;

import javax.validation.constraints.*;

public class User {
    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastName;

    @Pattern(regexp = "(\\+84|0)[0-9]{9}")
    private String phoneNumber;

    @Min(18)
    private int age;

    @Email
    private String email;

    public User() {
    }

    public User(@NotEmpty @Size(min = 5, max = 45) String firstName,@NotEmpty @Size(min = 5, max = 45) String lastName,
                @Pattern(regexp = "(\\+84|0)[0-9]{9}") String phoneNumber,@Min(18) int age,@Email String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
