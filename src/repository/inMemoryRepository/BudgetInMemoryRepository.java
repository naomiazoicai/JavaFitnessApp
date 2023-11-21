package repository.inMemoryRepository;

import domain.money.Budget;
import repository.interfaces.IBudgetRepo;

public class BudgetInMemoryRepository implements IBudgetRepo
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

    @Override
    public void addMoney(double value){
        budget.addMoney(value);
    }

    @Override
    public void spendMoney(double value) throws Exception {
        budget.spendMoney(value);
    }

    @Override
    public double getCurrentMoney()
    {
        return budget.getCurrentMoney();
    }

    @Override
    public String budgetAsString()
    {
        return budget.toString();
    }
}
