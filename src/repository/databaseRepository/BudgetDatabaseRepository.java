package repository.databaseRepository;

import dao.BudgetDao;
import repository.interfaces.IBudgetRepo;

public class BudgetDatabaseRepository implements IBudgetRepo
{
    private static BudgetDatabaseRepository  instance;

    private final BudgetDao budgetDao;

    private BudgetDatabaseRepository ()
    {
        budgetDao = BudgetDao.getInstance();
    }

    public static BudgetDatabaseRepository getInstance()
    {
        if (instance == null) instance = new BudgetDatabaseRepository();
        return instance;
    }

    @Override
    public void addMoney(double value){
        budgetDao.addMoney(value);
    }

    @Override
    public void spendMoney(double value) throws Exception {
        budgetDao.spendMoney(value);
    }

    @Override
    public double getCurrentMoney()
    {
        return budgetDao.getCurrentMoney();
    }

    @Override
    public String budgetAsString()
    {
        return budgetDao.budgetAsString();
    }
}
