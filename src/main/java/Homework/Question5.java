package Homework;

import java.sql.*;

public class Question5 {
    public static void answer5() throws SQLException {
        //1-Connection to db
        String dbUrl="jdbc:postgresql://localhost:5432/dvdrental";
        String user="postgres";
        String password="1763";
        Connection connection = DriverManager.getConnection(dbUrl,user,password);

        //2-create a statement
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //3-execute a query
        String query="SELECT SUM(amount) FROM payment p\n" +
                "JOIN rental r ON r.rental_id = p.rental_id\n" +
                "JOIN inventory i ON i.inventory_id = r.inventory_id\n" +
                "WHERE i.store_id=2\n" +
                "AND r.return_date IS NOT NULL";
        ResultSet resultSet = statement.executeQuery(query);

        //4-process the resultSet
        int count=1;
        while(resultSet.next()){
            System.out.printf("%2d-%9s",count++,resultSet.getString("sum"));
        }

    }
}
