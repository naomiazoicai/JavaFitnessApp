package controller;

import controller.interfaces.observers.IObserverCustomerSubscriptionAdded;
import domain.money.CustomerSubscription;
import repository.inMemoryRepository.BudgetInMemoryRepository;

public class BudgetController implements IObserverCustomerSubscriptionAdded
{
    private static BudgetController instance;

    private final BudgetInMemoryRepository repository;

    private BudgetController(){repository = BudgetInMemoryRepository.getInstance();};

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
}
