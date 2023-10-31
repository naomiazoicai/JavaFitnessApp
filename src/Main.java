import UI.UI;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;
import repository.inMemoryRepository.InMemoryRepository;
import UI.CustomerUI;

public class Main {
//    Projekt: Java-Konsolenanwendung
//    dieses Dokument dient als Leitfaden für die Entwicklung einer Konsolenanwendung in Java.
    public static void main(String[] args) throws ObjectAlreadyContained, ObjectNotContained {
         UI ui = UI.getInstance();
         ui.runUi();

        CustomerUI customerUI = CustomerUI.getInstance();
       // customerUI.runUi();
    }
}