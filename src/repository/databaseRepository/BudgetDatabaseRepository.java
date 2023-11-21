package repository.databaseRepository;

import dao.BudgetDao;

public class BudgetDatabaseRepository
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

    public void addMoney(double value){
        budgetDao.addMoney(value);
    }

    public void spendMoney(double value) throws Exception {
        budgetDao.spendMoney(value);
    }

    public double getCurrentMoney()
    {
        return budgetDao.getCurrentMoney();
    }

    public String budgetAsString()
    {
        return budgetDao.toString();
    }
}
