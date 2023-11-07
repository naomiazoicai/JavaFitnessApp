package controller;

import repository.inMemoryRepository.BudgetRepository;

public class BudgetController {
    private static BudgetController instance;

    private final BudgetRepository repository = BudgetRepository.getInstance();

    private BudgetController(){};

    public static BudgetController getInstance()
    {
        if (instance == null) instance = new BudgetController();
        return instance;
    }

    public void addMoney(int value){
        repository.addMoney(value);
    }

    public void spendMoney(int value) throws Exception {
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
}
