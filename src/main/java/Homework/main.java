package Homework;

import java.sql.SQLException;
import java.sql.SQLOutput;

public class main {
    public static void main(String[] args) throws SQLException {
        System.out.println("1- The last 3 person’s name and rent date, who had rent any film of actor “Ed Chase”");
        Question1.answer1();

        System.out.println("----------------------------------------------------------");
        System.out.println("2-) Find the staff’s name, username and password who is working in the store that sells “Glass Dying” film");
        Question2.answer2();

        System.out.println("----------------------------------------------------------");
        System.out.println("3-What are the names of top 5 categories, that have more than 150 films in inventory of store-1?");
        Question3.answer3();

        System.out.println("----------------------------------------------------------");
        System.out.println("4-Which countries have made higher payments than 800$?(with their payment amount in desc order)v");
        Question4.answer4();

        System.out.println("----------------------------------------------------------");
        System.out.println("5-How much will store-2 earn when all the rented films are returned?");
        Question5.answer5();

    }
}
