package kg.rakhim.classes.dao;

import kg.rakhim.classes.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {
    private List<Person> people = new ArrayList<>();
    static int COUNT;

    {
        people.add(new Person(++COUNT, "Rakhim", "Nuraliev", "nuraliev@mail.com"));
        people.add(new Person(++COUNT, "Jon", "Stones", "stones@mail.com"));
        people.add(new Person(++COUNT, "Messi","Leo", "leo@mail.com"));
    }


    public List<Person> index() {
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }


    public void save(Person person){
        person.setId(++COUNT);
        people.add(person);
    }
}
