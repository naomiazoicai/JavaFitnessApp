package controller;

import domain.money.SubscriptionType;
import repository.inMemoryRepository.SubscriptionTypeRepository;


public class SubscriptionTypeController extends Controller<SubscriptionType>
{
    private static SubscriptionTypeController instance;

    private SubscriptionTypeController()
    {
        super(SubscriptionTypeRepository.getInstance());
    }

    public static SubscriptionTypeController getInstance()
    {
        if (instance == null) instance = new SubscriptionTypeController();
        return instance;
    }
}
