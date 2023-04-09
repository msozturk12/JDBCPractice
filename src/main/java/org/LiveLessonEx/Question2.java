package org.LiveLessonEx;

import java.sql.*;

public class Question2 {

    public static void answer2() throws SQLException {
        // 1-GET a connection to DB
        String dbURL = "jdbc:postgresql://localhost:5432/exercises";
        String username="postgres";
        String password="1763";
        Connection connection = DriverManager.getConnection(dbURL,username,password);

        //2-create a statemnt object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


        //3- execute a query
        String query ="SELECT TO_CHAR(joindate,'Month') AS month, COUNT(memid) AS count\n" +
                "FROM cd.members\n" +
                "GROUP BY TO_CHAR(joindate,'Month')\n" +
                "ORDER BY count DESC\n" +
                "LIMIT 1";
        ResultSet resultSet = statement.executeQuery(query);

        //4-process the resultset
        int count =1;
        while(resultSet.next()){
            System.out.println(count++ + ": " + resultSet.getString("month") + " count:" + resultSet.getString("count"));
        }

    }
}
