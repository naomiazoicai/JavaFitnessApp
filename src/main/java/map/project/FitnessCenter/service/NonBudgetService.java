package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.model.Customer;
import map.project.FitnessCenter.data.model.FreeSubscriptionsLog;
import map.project.FitnessCenter.data.model.Subscription;
import map.project.FitnessCenter.data.repository.Jpa.FreeSubscriptionLogRepo;
import map.project.FitnessCenter.decorator.SubscriptionServiceDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Service class for managing the given away subscriptions of the fitness center.
 */
@Service
public class NonBudgetService extends SubscriptionServiceDecorator {
    private final FreeSubscriptionLogRepo repository;
    private final SubscriptionService subscriptionService;

    @Autowired
    public NonBudgetService(FreeSubscriptionLogRepo repository, SubscriptionService subscriptionService) {
        super(subscriptionService);
        this.subscriptionService = subscriptionService;
        this.repository = repository;
    }

    @Override
    public void subscriptionSold(Subscription subscription) {
        FreeSubscriptionsLog logEntry = new FreeSubscriptionsLog();
        // Set username
        Customer customer = subscription.getCustomer();
        if (customer != null) logEntry.setPersonUsername(customer.getUsername());
        // Set currentDate
        LocalDate currentDate = LocalDate.now();
        logEntry.setDate(currentDate);
        // Save
        repository.save(logEntry);
    }

    @Override
    public void setSubscriptionType(Subscription object) {
        subscriptionService.setSubscriptionType(object);
    }
}
