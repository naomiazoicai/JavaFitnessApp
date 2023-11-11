import UI.SpecialisedUIs.BudgetUI;

public class Main {
//    Projekt: Java-Konsolenanwendung
//    dieses Dokument dient als Leitfaden für die Entwicklung einer Konsolenanwendung in Java.
    public static void main(String[] args){
        BudgetUI budgetUI = BudgetUI.getInstance();
        budgetUI.addMoney();
        budgetUI.spendMoney();
        budgetUI.spendMoney();
        budgetUI.showBudget();
    }
}