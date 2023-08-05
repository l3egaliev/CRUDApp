package kg.rakhim.classes.model;


public class Person {
    private int id;
    private String name;

    private String surname;
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
