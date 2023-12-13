package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.model.Subscription;
import map.project.FitnessCenter.data.model.SubscriptionType;
import map.project.FitnessCenter.decorator.SubscriptionServiceDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaidSubscriptionService extends SubscriptionServiceDecorator
{
    private final BudgetService budgetService;

    @Autowired
    public PaidSubscriptionService(BudgetService budgetService, SubscriptionService subscriptionService) {
        super(subscriptionService);
        this.budgetService = budgetService;
    }

    @Override
    public void subscriptionSold(Subscription subscription) {
        subscriptionService.setSubscriptionType(subscription);
        SubscriptionType subscriptionType = subscription.getSubscriptionType();
        if (subscriptionType != null) budgetService.addMoney(subscriptionType.getPrice());
    }

    @Override
    public void setSubscriptionType(Subscription object) {
        subscriptionService.setSubscriptionType(object);
    }
}

