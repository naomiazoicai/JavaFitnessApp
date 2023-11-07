package repository.inMemoryRepository;

import domain.money.Budget;

public class BudgetRepository
{
    private static BudgetRepository instance;

    private final Budget budget;

    private BudgetRepository(){
        budget = Budget.getInstance();
    };

    public static BudgetRepository getInstance()
    {
        if (instance == null) instance = new BudgetRepository();
        return instance;
    }

    public void addMoney(int value){
        budget.addMoney(value);
    }

    public void spendMoney(int value) throws Exception {
        budget.spendMoney(value);
    }

    public double getCurrentMoney()
    {
        return budget.getCurrentMoney();
    }

    public String budgetAsString()
    {
        return budget.toString();
    }
}
