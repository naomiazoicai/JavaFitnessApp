package UI.SpecialisedUIs;

import UI.Terminal;
import controller.BudgetController;

public class BudgetUI {
    private static BudgetUI instance;

    private final BudgetController controller;

    private final Terminal terminal = Terminal.getInstance();

    private BudgetUI()
    {
        controller = BudgetController.getInstance();
    }

    public static BudgetUI getInstance()
    {
        if (instance == null) instance = new BudgetUI();
        return instance;
    }

    public void addMoney()
    {
        double amount = terminal.readMoneyAmount();
        controller.addMoney(amount);
        terminal.printMessage("New amount: " + controller.getCurrentMoney());
    }

    public void spendMoney()
    {
        double amount = terminal.readMoneyAmount();
        try {
            controller.spendMoney(amount);
            terminal.printMessage("New amount: " + controller.getCurrentMoney());
        } catch (Exception e) {
            terminal.printMessage("Insufficient founds!");
        }
    }

    public void showBudget()
    {
        terminal.printMessage(controller.budgetAsString());
    }
}
