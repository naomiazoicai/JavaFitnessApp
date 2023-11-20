
import UI.Terminal;
import dao.DatabaseConnection;
import dao.EquipmentItemDao;
import domain.gym.EquipmentItem;
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

        EquipmentItemDao dao = EquipmentItemDao.getInstance();

//        System.out.println(dao.generateNextId());

//        System.out.println(dao.searchById(2));

//        System.out.println(dao.idInRepo(2));

//        try {
//            dao.insertEntity(new EquipmentItem("Test"));
//        } catch (ObjectAlreadyContained e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            dao.deleteEntity(new EquipmentItem(3));
//        } catch (ObjectNotContained e) {
//            System.out.println(e.getMessage());
//        }

        try {
            dao.updateEntity(new EquipmentItem(4, "Spoon"));
        } catch (ObjectNotContained e) {
            System.out.println(e.getMessage());
        }

        Terminal.getInstance().printArrayList(dao.getAllEntities());

        //        MainUI mainUI = MainUI.getInstance();
        //        mainUI.runUi();
    }
}