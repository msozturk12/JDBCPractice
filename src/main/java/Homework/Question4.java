package Homework;

import java.sql.*;

public class Question4 {
    public static void answer4() throws SQLException {
        //1-connection to db
        String dbUrl="jdbc:postgresql://localhost:5432/dvdrental";
        String user="postgres";
        String password="1763";
        Connection connection = DriverManager.getConnection(dbUrl,user,password);
        //2-create a statement
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //3-execute a query
        String query="SELECT country,SUM(amount) as payments_amount FROM country co\n" +
                "JOIN city ci  ON ci.country_id=co.country_id\n" +
                "JOIN address a ON a.city_id = ci.city_id\n" +
                "JOIN customer cu ON cu.address_id = a.address_id\n" +
                "JOIN payment p ON p.customer_id=cu.customer_id\n" +
                "GROUP BY co.country\n" +
                "HAVING SUM(amount) >800\n" +
                "ORDER BY SUM(amount) DESC";
        ResultSet resultSet = statement.executeQuery(query);
        //4-process the resultSet
        int count=1;
        while(resultSet.next()){
            System.out.printf("%3d- %-20s %8s\n",count++,resultSet.getString("country"),
                    resultSet.getString("payments_amount"));

        }
    }
}
