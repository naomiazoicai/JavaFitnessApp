import UI.SpecialisedUIs.SpecialisedRoomUI;


public class Main {
//    Projekt: Java-Konsolenanwendung
//    dieses Dokument dient als Leitfaden für die Entwicklung einer Konsolenanwendung in Java.
    public static void main(String[] args){
        SpecialisedRoomUI specialisedRoomUI = SpecialisedRoomUI.getInstance();
        specialisedRoomUI.deleteEntity();
        specialisedRoomUI.showAll();
    }
}