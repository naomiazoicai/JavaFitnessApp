
import UI.Terminal;
import dao.CustomerDao;
import dao.DatabaseConnection;
import dao.TrainerDao;
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

        CustomerDao dao = CustomerDao.getInstance();

//        System.out.println(dao.keyNameInRepo("gigiSlay"));

//        System.out.println(dao.searchByKeyName("yourBoss"));

//        Terminal.getInstance().printArrayList(dao.searchByPartialKeyName("i"));

//        System.out.println(dao.generateNextId());

//        System.out.println(dao.searchById(2));

//        System.out.println(dao.idInRepo(2));

//        dao.equipmentItemDeleted(new EquipmentItem(10));

//        try {
//            EmployeeDao.getInstance().addEntity(new Trainer("swiftie", "Taylor Swift", LocalDate.of(1950, 10, 10), Gender.female, 1000, TrainerSpecialization.Box));
//        } catch (ObjectAlreadyContained e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            dao.addEntity(new Customer("yone", "ionel", LocalDate.of(2000, 10, 10),
//                    Gender.male, new Trainer("giovanniBecali")));
//        } catch (ObjectAlreadyContained e) {
//            System.out.println(e.getMessage());
//        }

//        dao.trainerDeleted(new Trainer("giovanniBecali"));

//        try {
//            dao.deleteEntity(new Customer("yone"));
//        } catch (ObjectNotContained e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            dao.updateEntity(new Customer("yone", "ionela", LocalDate.of(2000, 10, 10),
//                Gender.male, new Trainer("giovanniBecali")));
//        } catch (ObjectNotContained e) {
//            System.out.println(e.getMessage());
//        }
//
//        Terminal.getInstance().printArrayList(dao.getAllEntities());

        //        MainUI mainUI = MainUI.getInstance();
        //        mainUI.runUi();
    }
}