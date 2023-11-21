package repository.interfaces;

public interface IBudgetRepo
{
    void addMoney(double value);

    void spendMoney(double value) throws Exception;

    double getCurrentMoney();

    String budgetAsString();
}
