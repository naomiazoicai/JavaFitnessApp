
import UI.Terminal;
import dao.DatabaseConnection;
import dao.SpecialisedRoomDao;


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

        SpecialisedRoomDao dao = SpecialisedRoomDao.getInstance();

//        System.out.println(dao.generateNextId());

//        System.out.println(dao.searchById(2));

//        System.out.println(dao.idInRepo(2));

//        dao.equipmentItemDeleted(new EquipmentItem(10));

//        try {
//            dao.addEntity(new SpecialisedRoom(false, RoomAccess.subscriptionRestricted, RoomType.freeWeights, 5));
//        } catch (ObjectAlreadyContained e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            dao.deleteEntity(new SpecialisedRoom(3));
//        } catch (ObjectNotContained e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            dao.updateEntity(new SpecialisedRoom(3, false, RoomAccess.employee, RoomType.empty, 23));
//        } catch (ObjectNotContained e) {
//            System.out.println(e.getMessage());
//        }

        Terminal.getInstance().printArrayList(dao.getAllEntities());

        //        MainUI mainUI = MainUI.getInstance();
        //        mainUI.runUi();
    }
}