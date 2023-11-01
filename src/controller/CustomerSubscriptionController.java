package controller;

import domain.money.CustomerSubscription;
import repository.inMemoryRepository.CustomerSubscriptionRepository;


public class CustomerSubscriptionController extends Controller<CustomerSubscription>
{
    private static CustomerSubscriptionController instance;

    private CustomerSubscriptionController()
    {
        super(CustomerSubscriptionRepository.getInstance());
    }

    public static CustomerSubscriptionController getInstance()
    {
        if (instance == null) instance = new CustomerSubscriptionController();
        return instance;
    }
}
