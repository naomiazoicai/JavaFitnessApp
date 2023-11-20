import UI.MainUI;
import UI.Terminal;
import dao.DatabaseConnection;
import dao.SubscriptionTypeDao;
import dao.TestDao;
import domain.money.SubscriptionType;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

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

        // Test methods
//        try {
//            SubscriptionTypeDao.getInstance().insertEntity(new SubscriptionType("Platinum", "King", 100));
//
//        } catch (ObjectAlreadyContained e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            SubscriptionTypeDao.getInstance().deleteEntity(new SubscriptionType("Platinum"));
//        } catch (ObjectNotContained e) {
//            System.out.println(e);
//        }
//
//        try {
//            SubscriptionTypeDao.getInstance().updateEntity(new SubscriptionType("Platinum", "Full access plan", 40));
//        } catch (ObjectNotContained e) {
//            System.out.println(e);
//        }

//        Terminal.getInstance().printArrayList(SubscriptionTypeDao.getInstance().getAllEntities());

//        System.out.println(SubscriptionTypeDao.getInstance().keyNameInRepo("Silver"));

//        Terminal.getInstance().printArrayList(SubscriptionTypeDao.getInstance().searchByPartialKeyName("i"));

//        System.out.println(SubscriptionTypeDao.getInstance().searchByKeyName("Silver"));


//        TestDao.getAllSubscriptionTypes();

        //        MainUI mainUI = MainUI.getInstance();
        //        mainUI.runUi();
    }
}