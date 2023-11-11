import UI.SpecialisedUIs.CustomerSubscriptionUI;

public class Main {
//    Projekt: Java-Konsolenanwendung
//    dieses Dokument dient als Leitfaden für die Entwicklung einer Konsolenanwendung in Java.
    public static void main(String[] args){
        CustomerSubscriptionUI customerSubscriptionUI = CustomerSubscriptionUI.getInstance();
        customerSubscriptionUI.searchSubscriptionByType();
        customerSubscriptionUI.searchSubscriptionsOfUser();
    }
}