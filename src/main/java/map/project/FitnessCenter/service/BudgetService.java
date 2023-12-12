package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.model.Budget;
import map.project.FitnessCenter.data.model.Subscription;
import map.project.FitnessCenter.data.model.SubscriptionType;
import map.project.FitnessCenter.data.repository.Jpa.BudgetRepository;
import map.project.FitnessCenter.decorator.SubscriptionServiceDecorator;
import map.project.FitnessCenter.service.interfaces.IBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService extends SubscriptionServiceDecorator implements IBudgetService {
    private final BudgetRepository repository;

    @Autowired
    public BudgetService(BudgetRepository repository, SubscriptionService subscriptionService) {
        super(subscriptionService);
        this.repository = repository;
    }

    @Override
    public void subscriptionSold(Subscription subscription) {
        subscriptionService.setSubscriptionType(subscription);
        SubscriptionType subscriptionType = subscription.getSubscriptionType();
        if (subscriptionType != null) addMoney(subscriptionType.getPrice());
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

    @Override
    public void setSubscriptionType(Subscription object) {
        subscriptionService.setSubscriptionType(object);
    }
}
