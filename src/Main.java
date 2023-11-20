
import UI.Terminal;
import dao.DatabaseConnection;
import dao.ExerciseDao;



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

        ExerciseDao dao = ExerciseDao.getInstance();

//        System.out.println(dao.generateNextId());

//        System.out.println(dao.searchById(3));

//        System.out.println(dao.idInRepo(3));

//        dao.equipmentItemDeleted(new EquipmentItem(10));

//        try {
//            dao.insertEntity(new Exercise(11, "Run", "leg", new EquipmentItem(3), 100, 100));
//        } catch (ObjectAlreadyContained e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            dao.deleteEntity(new Exercise(13));
//        } catch (ObjectNotContained e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            dao.updateEntity(new Exercise(11, "Run", "leg", new EquipmentItem(3), 100, 100));
//        } catch (ObjectNotContained e) {
//            System.out.println(e.getMessage());
//        }

        Terminal.getInstance().printArrayList(dao.getAllEntities());

        //        MainUI mainUI = MainUI.getInstance();
        //        mainUI.runUi();
    }
}