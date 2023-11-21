
import dao.DatabaseConnection;
import dao.PersonDao;

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

        PersonDao dao = PersonDao.getInstance();

//        System.out.println(dao.keyNameInRepo("swift"));

        System.out.println(dao.searchByKeyName("swiftie"));

//        System.out.println(dao.generateNextId());

//        System.out.println(dao.searchById(2));

//        System.out.println(dao.idInRepo(2));

//        dao.equipmentItemDeleted(new EquipmentItem(10));

//        try {
//            dao.addEntity(new Person("yone", "ionel", LocalDate.of(2000, 10, 10), Gender.male));
//        } catch (ObjectAlreadyContained e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            dao.deleteEntity(new Person("yone"));
//        } catch (ObjectNotContained e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            dao.updateEntity(new Person("yone", "ionelul", LocalDate.of(2002, 12, 10), Gender.female));
//        } catch (ObjectNotContained e) {
//            System.out.println(e.getMessage());
//        }

//        Terminal.getInstance().printArrayList(dao.getAllEntities());

        //        MainUI mainUI = MainUI.getInstance();
        //        mainUI.runUi();
    }
}