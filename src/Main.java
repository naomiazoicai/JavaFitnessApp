
import UI.Terminal;
import dao.CustomerDao;
import dao.DatabaseConnection;
import dao.SubscriptionTypeDao;
import dao.TrainerDao;
import domain.gym.Room;
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

        SubscriptionTypeDao dao = SubscriptionTypeDao.getInstance();

//        dao.addRoomToSubscription(new SubscriptionType("Gold"), new Room(4));

        dao.removeRoomFromSubscription(new SubscriptionType("Gold"), new Room(4));

//        dao.roomDeleted(new Room(4));


//        System.out.println(dao.searchByKeyName("Gold"));

//        Terminal.getInstance().printArrayList(dao.searchByPartialKeyName("l"));

        Terminal.getInstance().printArrayList(dao.getAllEntities());

        //        MainUI mainUI = MainUI.getInstance();
        //        mainUI.runUi();
    }
}