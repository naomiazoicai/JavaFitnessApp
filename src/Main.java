import UI.Terminal;

import dao.DatabaseConnection;


import java.sql.SQLException;

public class Main {
//    Projekt: Java-Konsolenanwendung
    public static void main(String[] args){
        // Connect to database
        try {
            DatabaseConnection.setConnection("jdbc:mysql://localhost:3306/javaapp", "coders", "ThisIsOurDatabase.2023");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }


//                MainUI mainUI = MainUI.getInstance();
//                mainUI.runUi();
    }
}