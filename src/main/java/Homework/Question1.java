package Homework;

import java.sql.*;

public class Question1 {
    public static void answer1() throws SQLException {
        //1-Connection to DB
        String dbUrl="jdbc:postgresql://localhost:5432/dvdrental";
        String user ="postgres";
        String password="1763";

        Connection connection = DriverManager.getConnection(dbUrl,user,password);

        //2-create a statement
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //3-execute a query
        String query="SELECT c.first_name,c.last_name,r.rental_date FROM customer c\n" +
                "JOIN rental r ON r.customer_id = c.customer_id\n" +
                "JOIN inventory i ON i.inventory_id = r.inventory_id\n" +
                "JOIN film_actor fa ON fa.film_id = i.film_id\n" +
                "JOIN actor a ON a.actor_id = fa.actor_id\n" +
                "WHERE a.first_name='Ed' AND a.last_name='Chase'\n" +
                "ORDER BY r.rental_date DESC\n" +
                "LIMIT 3\n";
        ResultSet resultSet = statement.executeQuery(query);

        //4-process the resultset
        int count=1;
        while(resultSet.next()){
            System.out.println(count++ + "-)" + resultSet.getString("first_name") + " " +
                    resultSet.getString("last_name") + "-----" +
                    resultSet.getString("rental_date"));
        }
    }
}
