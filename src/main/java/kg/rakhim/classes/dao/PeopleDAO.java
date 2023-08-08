package kg.rakhim.classes.dao;

import kg.rakhim.classes.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource("classpath:db.properties")
public class PeopleDAO {

    private static String URL = "jdbc:mysql://localhost:3306/person";
    private static String user = "root";
    private static String password = "testtest";
    private static final Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM person");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return people;
    }


    public Person show(int id){
        Person person = new Person();

        try {
          PreparedStatement preparedStatement =
                  connection.prepareStatement("SELECT * from person where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
              person.setId(resultSet.getInt("id"));
              person.setName(resultSet.getString("name"));
              person.setSurname(resultSet.getString("surname"));
              person.setEmail(resultSet.getString("email"));

          }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }


    public void save(Person person){
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO person(name, surname, email) VALUES (?, ?, ?)");

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setString(3, person.getEmail());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void update(int id, Person updatedPerson){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE person set name = ?, surname = ?, email = ? where id = ?");

            preparedStatement.setString(1, updatedPerson.getName());
            preparedStatement.setString(2, updatedPerson.getSurname());
            preparedStatement.setString(3, updatedPerson.getEmail());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM person WHERE id = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
