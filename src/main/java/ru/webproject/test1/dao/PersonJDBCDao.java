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

    public PersonJDBC showUser(int user_id) {
        PersonJDBC person = new PersonJDBC();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name,age,email FROM Person WHERE id = ?");
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));
            person.setEmail(resultSet.getString("email"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public void insert(PersonJDBC person) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Person VALUES(?,?,?,?)");
            preparedStatement.setInt(1, ++count);
            preparedStatement.setString(2, person.getName());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setString(4, person.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, PersonJDBC updPerson) {
        //Prepared statement commands
        //UPDATE Person SET name=?, age=?, email=? WHERE id=?
        // .executeUpdate()
    }

    public void delete(int id) {
        //Prepared statement commands
        //DELETE FROM Person WHERE id=?
        // .executeUpdate()
    }
}
