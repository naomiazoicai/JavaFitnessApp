import UI.SpecialisedUIs.SubscriptionTypeUI;


public class Main {
//    Projekt: Java-Konsolenanwendung
//    dieses Dokument dient als Leitfaden für die Entwicklung einer Konsolenanwendung in Java.
    public static void main(String[] args){
        SubscriptionTypeUI subscriptionTypeUI = SubscriptionTypeUI.getInstance();

        subscriptionTypeUI.searchByPartialName();
    }
}