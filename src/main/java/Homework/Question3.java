package Homework;

import java.sql.*;

public class Question3 {
    public static void answer3() throws SQLException {

        //1-Connection to db
        String dbUrl="jdbc:postgresql://localhost:5432/dvdrental";
        String user="postgres";
        String password="1763";
        Connection connection = DriverManager.getConnection(dbUrl,user,password);
        //2-create statement
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //3-execute the query
        String query="SELECT name,COUNT(*) AS film_count FROM category c\n" +
                "JOIN film_category fc ON fc.category_id = c.category_id\n" +
                "JOIN inventory i ON i.film_id = fc.film_id\n" +
                "WHERE i.store_id = 1\n" +
                "GROUP BY name\n" +
                "HAVING COUNT(*)>150\n" +
                "ORDER BY COUNT(*) DESC\n" +
                "LIMIT 5";
        ResultSet resultSet = statement.executeQuery(query);
        //4-process resultset
        int count=1;
        while(resultSet.next()){
            System.out.printf("%2d-)%-10s %4s\n",count++,resultSet.getString("name"),
                    resultSet.getString("film_count"));
        }
    }
}
