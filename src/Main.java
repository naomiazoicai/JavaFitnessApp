import UI.SpecialisedUIs.EquipmentItemUI;
import UI.SpecialisedUIs.ExerciseUI;

public class Main {
//    Projekt: Java-Konsolenanwendung
//    dieses Dokument dient als Leitfaden für die Entwicklung einer Konsolenanwendung in Java.
    public static void main(String[] args){
        EquipmentItemUI equipmentItemUI = EquipmentItemUI.getInstance();
        ExerciseUI exerciseUI = ExerciseUI.getInstance();

        exerciseUI.showAll();
        equipmentItemUI.deleteEntity();
        exerciseUI.showAll();
    }
}