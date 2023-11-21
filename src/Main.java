
import UI.Terminal;
import dao.CustomerDao;
import dao.DatabaseConnection;
import dao.SubscriptionTypeDao;
import dao.TrainerDao;
import dao.interaces.CustomerSubscriptionDao;
import domain.gym.Room;
import domain.money.CustomerSubscription;
import domain.money.SubscriptionType;
import domain.persons.Customer;
import domain.persons.Gender;
import domain.persons.Trainer;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.sql.SQLException;
import java.time.LocalDate;

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

        CustomerSubscriptionDao dao = CustomerSubscriptionDao.getInstance();

//        Terminal.getInstance().printArrayList(dao.searchSubscriptionsOfUser("swiftie"));

//        Terminal.getInstance().printArrayList(dao.searchSubscriptionByType(new SubscriptionType("Gold")));

//        System.out.println(dao.hasValidSubscription(new Customer("gigiSlay")));

//        try {
//            dao.addEntity(new CustomerSubscription(new Customer("swiftie"), new SubscriptionType("Test"),
//                    LocalDate.of(2022, 8, 1), LocalDate.of(2023, 7, 12)));
//        } catch (ObjectAlreadyContained e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            dao.updateEntity(new CustomerSubscription(new Customer("swiftie"), new SubscriptionType("Gold"),
//                    LocalDate.of(2022, 8, 1), LocalDate.of(2023, 7, 12)));
//        } catch (ObjectNotContained e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            dao.deleteEntity(new CustomerSubscription(new Customer("swiftie"), new SubscriptionType("Gold"),
//                    LocalDate.of(2022, 8, 1), LocalDate.of(2023, 7, 12)));
//        } catch (ObjectNotContained e) {
//            System.out.println(e.getMessage());
//        }

//        dao.subscriptionTypeDeleted(new SubscriptionType("Test"));

        Terminal.getInstance().printArrayList(dao.getAllEntities());

        //        MainUI mainUI = MainUI.getInstance();
        //        mainUI.runUi();
    }
}