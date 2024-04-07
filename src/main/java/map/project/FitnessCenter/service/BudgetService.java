package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.model.Budget;
import map.project.FitnessCenter.data.repository.Jpa.BudgetRepository;
import map.project.FitnessCenter.service.interfaces.IBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing the budget of the fitness center.
 */
@Service
public class BudgetService implements IBudgetService {
    private final BudgetRepository repository;

    @Autowired
    public BudgetService(BudgetRepository repository) {
        this.repository = repository;
    }


    @Override
    public void addMoney(double amount) {
        Budget budget = repository.getReferenceById(1);
        budget.addMoney(amount);
        repository.save(budget);
    }

    @Override
    public void spendMoney(double amount) {
        Budget budget = repository.getReferenceById(1);
        budget.spendMoney(amount);
        repository.save(budget);
    }

    @Override
    public String getBudget() {
        Budget budget = repository.getReferenceById(1);
        return "Budget: " + budget.getCurrentMoney() + " EURO";
    }
}
