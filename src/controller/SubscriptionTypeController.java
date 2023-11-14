package controller;

import controller.interfaces.ISubscriptionTypeController;
import domain.money.SubscriptionType;
import repository.inMemoryRepository.SubscriptionTypeRepository;
import repository.interfaces.ISubscriptionTypeRepository;

import java.util.ArrayList;


public class SubscriptionTypeController extends Controller<SubscriptionType> implements ISubscriptionTypeController
{
    private static SubscriptionTypeController instance;

    private final ISubscriptionTypeRepository subscriptionTypeRepository;

    private SubscriptionTypeController(SubscriptionTypeRepository subscriptionTypeRepository)
    {
        super(subscriptionTypeRepository);
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    public static SubscriptionTypeController getInstance()
    {
        if (instance == null) instance = new SubscriptionTypeController(SubscriptionTypeRepository.getInstance());
        return instance;
    }

    @Override
    public ArrayList<SubscriptionType> searchByPartialKeyName(String keyName) {
        return subscriptionTypeRepository.searchByPartialKeyName(keyName);
    }

    @Override
    public SubscriptionType searchByKeyName(String keyName) {
        return subscriptionTypeRepository.searchByKeyName(keyName);
    }

    @Override
    public Boolean keyNameInRepo(String keyName) {
        return subscriptionTypeRepository.keyNameInRepo(keyName);
    }
}
