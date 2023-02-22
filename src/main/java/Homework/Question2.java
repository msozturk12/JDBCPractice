package Homework;

import java.sql.*;
import java.util.concurrent.Executor;

public class Question2 {

    public static void answer2() throws SQLException {
        //1-Connection to DB
        String dbUrl="jdbc:postgresql://localhost:5432/dvdrental";
        String user="postgres";
        String password="1763";
        Connection connection = DriverManager.getConnection(dbUrl,user,password);

        //2-create a Statement
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //3-execute the query
        String query="SELECT first_name,username,password FROM staff s\n" +
                "JOIN inventory i ON i.store_id = s.store_id\n" +
                "JOIN film f ON f.film_id = i.film_id\n" +
                "WHERE f.title='Glass Dying'";
        ResultSet resultSet = statement.executeQuery(query);

        //4-process the result set
        int count=1;
        while(resultSet.next()){
            System.out.println(count++ + "-" + resultSet.getString("first_name") + " " +
                    resultSet.getString("username") + "---" +
                    resultSet.getString("password"));
        }

    }


}
