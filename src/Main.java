import UI.SpecialisedUIs.EquipmentItemUI;

public class Main {
//    Projekt: Java-Konsolenanwendung
//    dieses Dokument dient als Leitfaden für die Entwicklung einer Konsolenanwendung in Java.
    public static void main(String[] args){
        EquipmentItemUI ui = EquipmentItemUI.getInstance();
        ui.addEntity();
        ui.showAll();
    }
}