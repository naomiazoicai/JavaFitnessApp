package repository.inMemoryRepository;

import domain.money.Budget;

public class BudgetInMemoryRepository
{
    private static BudgetInMemoryRepository instance;

    private final Budget budget;

    private BudgetInMemoryRepository(){
        budget = Budget.getInstance();
    }

    public static BudgetInMemoryRepository getInstance()
    {
        if (instance == null) instance = new BudgetInMemoryRepository();
        return instance;
    }

    public void addMoney(double value){
        budget.addMoney(value);
    }

    public void spendMoney(double value) throws Exception {
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
