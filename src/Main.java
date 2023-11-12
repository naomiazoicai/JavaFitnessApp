import UI.MainUI;
import UI.SpecialisedUIs.*;

public class Main {
//    Projekt: Java-Konsolenanwendung
//    dieses Dokument dient als Leitfaden für die Entwicklung einer Konsolenanwendung in Java.
    public static void main(String[] args){
        MainUI mainUI = MainUI.getInstance();
        mainUI.runUi();
    }
}