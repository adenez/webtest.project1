package ru.webproject.test1.dao;

import ru.webproject.test1.model.PersonJDBC;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PersonJDBCDao {
    //счетчик пользователей
    private static int count = 5;
    //обьект подключения к БД
    private static Connection connection;

    /* подключение к БД, с использованием database.properties в resources
       вписано в ДАО для меньшей траты времени*/
    static {
        try {
            //чтение файла properties
            Properties prop = new Properties();
            InputStream in = new FileInputStream("database.properties");
            prop.load(in);
            in.close();

            //получения необходимых данных из файла
            String driverClass = prop.getProperty("JDBC.driver");
            String url = prop.getProperty("JDBC.url");
            String username = prop.getProperty("JDBC.username");
            String password = prop.getProperty("JDBC.password");

            Class.forName(driverClass);

            connection = DriverManager.getConnection(url, username, password);
        }

        //общие исключения для меньшей траты времени. Лучше конкретизировать на каждый случай
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<PersonJDBC> index() {
        List<PersonJDBC> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                PersonJDBC person = new PersonJDBC();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public PersonJDBC show() {
        return null;
    }

    public void save(PersonJDBC person) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + count + ",'" + person.getName() +
                    "'," + person.getAge() + ",'" + person.getEmail() + "')";
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(int id, PersonJDBC updPerson) {

    }

    public void delete(int id) {

    }
}
