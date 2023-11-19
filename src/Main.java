import UI.MainUI;
import dao.DatabaseConnection;
import dao.TestDao;

import java.sql.SQLException;

public class Main {
//    Projekt: Java-Konsolenanwendung
//    dieses Dokument dient als Leitfaden für die Entwicklung einer Konsolenanwendung in Java.
    public static void main(String[] args){
        // Connect to database
        try {
            DatabaseConnection.setConnection("jdbc:mysql://localhost:3306/javaapp", "coders", "ThisIsOurDatabase.2023");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        TestDao.getAllSubscriptionTypes();

        //        MainUI mainUI = MainUI.getInstance();
        //        mainUI.runUi();
    }
}