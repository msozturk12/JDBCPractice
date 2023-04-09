package Homework;

import java.sql.*;

public class QuestionEX {
    public static void answerEx() throws SQLException {

        //1-Connection to db

        String dbUrl="jdbc:postgresql://localhost:5432/dvdrental";
        String user="postgres";
        String password="1763";
        Connection connection = DriverManager.getConnection(dbUrl,user,password);

        //2-create a statement
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //3-execute query
        String query="";
        ResultSet resultSet = statement.executeQuery(query);

        //4-process the Resultset
        int count=1;
        while(resultSet.next()){
            System.out.println(count++  + resultSet.getString("columnName"));
             System.out.println(count++  + resultSet.getString("anotherColumnName"));
   System.out.println(count++  + resultSet.getString("anotherColumnName1"));
   System.out.println(count++  + resultSet.getString("anotherColumsdfsafsdfnName2"));
            
             System.out.println(count++  + resultSet.getString("anotherColumnName"));
   System.out.println(count++  + resultSet.getString("anotherColumnName1"));
   System.out.println(count++  + resultSet.getString("anotherColumsdfsafsdfnName2"));
            //sdfsdfsdfdsfsdf
        }
    }
}
