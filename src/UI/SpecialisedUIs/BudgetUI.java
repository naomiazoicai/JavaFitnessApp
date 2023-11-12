package UI.SpecialisedUIs;

import UI.Terminal;
import controller.BudgetController;

import java.util.Objects;

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

    public void run()
    {
        terminal.printMessage("Budget UI is running...");
        String choice = terminal.budgetUiMenu();
        // If choice == 4 -> return to main menu
        while (!Objects.equals(choice, "4"))
        {
            switch (choice)
            {
                case "1": showBudget(); break;
                case "2": addMoney(); break;
                case "3": spendMoney(); break;
            }
            terminal.pressEnterToContinue();
            choice = terminal.budgetUiMenu();
        }
    }

    private void addMoney()
    {
        double amount = terminal.readMoneyAmount();
        controller.addMoney(amount);
        terminal.printMessage("New amount: " + controller.getCurrentMoney());
    }

    private void spendMoney()
    {
        double amount = terminal.readMoneyAmount();
        try {
            controller.spendMoney(amount);
            terminal.printMessage("New amount: " + controller.getCurrentMoney());
        } catch (Exception e) {
            terminal.printMessage("Insufficient founds!");
        }
    }

    private void showBudget()
    {
        terminal.printMessage(controller.budgetAsString());
    }
}
