package controller;

import controller.interfaces.observers.IObserverCustomerSubscriptionAdded;
import domain.money.CustomerSubscription;
import factory.repo.BudgetRepoFactory;
import repository.RepoTypes;
import repository.interfaces.IBudgetRepo;

public class BudgetController implements IObserverCustomerSubscriptionAdded
{
    private static BudgetController instance;

    private final IBudgetRepo repository;

    private static RepoTypes repoType;

    private BudgetController()
    {
        if (repoType == null) throw new RuntimeException();
        this.repository = BudgetRepoFactory.buildInterface(repoType);
    }

    public static BudgetController getInstance()
    {
        if (instance == null) instance = new BudgetController();
        return instance;
    }

    public void addMoney(double value){
        repository.addMoney(value);
    }

    public void spendMoney(double value) throws Exception
    {
        repository.spendMoney(value);
    }

    public double getCurrentMoney()
    {
        return repository.getCurrentMoney();
    }

    public String budgetAsString()
    {
        return repository.budgetAsString();
    }

    @Override
    public void updatedAddedCustomerSubscription(CustomerSubscription customerSubscription)
    {
        addMoney(customerSubscription.getSubscriptionType().getPrice());
    }

    public static void setRepoType(RepoTypes newRepoType)
    {
        repoType = newRepoType;
    }
}
