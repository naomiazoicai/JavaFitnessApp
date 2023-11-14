import UI.MainUI;
import UI.SpecialisedUIs.SubscriptionTypeUI;
import controller.SpecialisedRoomController;
import controller.SubscriptionTypeController;
import controller.interfaces.ISpecialisedRoomController;
import domain.gym.Room;
import domain.gym.SpecialisedRoom;
import domain.money.SubscriptionType;
import repository.exceptions.ObjectNotContained;

import java.util.ArrayList;

public class Main {
//    Projekt: Java-Konsolenanwendung
//    dieses Dokument dient als Leitfaden für die Entwicklung einer Konsolenanwendung in Java.
    public static void main(String[] args){
        MainUI mainUI = MainUI.getInstance();
        mainUI.runUi();
    }
}