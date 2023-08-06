package kg.rakhim.classes.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.lang.annotation.Native;

public class Person {
    private int id;
    @NotEmpty(message = "Enter the name!")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters!")
    @NotBlank(message = "Write with characters")
    private String name;

    @NotEmpty(message = "Enter the surname!")
    @Size(min = 2, max = 30, message = "Surname should be between 2 and 40 characters!")
    @NotBlank(message = "Write with characters!")
    private String surname;

    @NotEmpty(message = "Enter the email!")
    @Email(message = "Enter the valid email!")
    @NotBlank(message = "Write with characters!")
    private String email;

    public Person() {
    }

    public Person(int id, String name, String surname,String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
