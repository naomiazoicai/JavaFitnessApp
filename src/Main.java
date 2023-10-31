import UI.UI;
import repository.inMemoryRepository.CustomerRepositoryTest;
import repository.inMemoryRepository.InMemoryRepository;

public class Main {
//    Projekt: Java-Konsolenanwendung
//    dieses Dokument dient als Leitfaden für die Entwicklung einer Konsolenanwendung in Java.
    public static void main(String[] args)
    {
         InMemoryRepository repository = InMemoryRepository.getInstance();
         UI ui = UI.getInstance(repository);
         //ui.runUi();

    }
}