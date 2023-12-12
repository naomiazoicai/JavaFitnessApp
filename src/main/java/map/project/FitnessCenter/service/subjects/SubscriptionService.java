package map.project.FitnessCenter.service.subjects;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.Customer;
import map.project.FitnessCenter.data.model.Subscription;
import map.project.FitnessCenter.data.model.SubscriptionType;
import map.project.FitnessCenter.data.repository.Jpa.SubscriptionRepository;
import map.project.FitnessCenter.data.repository.intefaces.ICustomSubscriptionRepository;
import map.project.FitnessCenter.service.BaseService;
import map.project.FitnessCenter.service.CustomerService;
import map.project.FitnessCenter.service.SubscriptionTypeService;
import map.project.FitnessCenter.service.observers.IObserverDeletedCustomer;
import map.project.FitnessCenter.service.observers.IObserverDeletedSubscriptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionService extends BaseService<Subscription, Long> implements IObserverDeletedCustomer,
        IObserverDeletedSubscriptionType {
    private final ICustomSubscriptionRepository subscriptionRepository;
    private final CustomerService customerService;
    private final SubscriptionTypeService subscriptionTypeService;

    @Autowired
    SubscriptionService(SubscriptionRepository repository, CustomerService customerService,
                        SubscriptionTypeService subscriptionTypeService)
    {
        super(repository);
        this.subscriptionRepository = repository;
        this.customerService = customerService;
        this.subscriptionTypeService = subscriptionTypeService;
        customerService.addObserver(this);
        subscriptionTypeService.addObserver(this);
    }

    @Override
    public Optional<Subscription> add(Subscription object) throws ObjectAlreadyContained {
        setCustomer(object);
        setSubscriptionType(object);
        return super.add(object);
    }

    @Override
    public Optional<Subscription> update(Long id, Subscription object) throws ObjectNotContained, ObjectAlreadyContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
        // Save old object
        Optional<Subscription> oldObject = repository.findById(id).map(Subscription::copy);
        // Update
        setCustomer(object);
        setSubscriptionType(object);
        object.setId(id);
        repository.save(object);
        return oldObject;
    }

    @Override
    public Optional<Subscription> delete(Long id) throws ObjectNotContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
        Optional<Subscription> oldObject = repository.findById(id);
        repository.deleteById(id);
        return oldObject;
    }

    private void setCustomer(Subscription object)
    {
        if (object.getCustomer() == null) return;
        Optional<Customer> customer = customerService.getEntityByKey(object.getCustomer().getUsername());
        customer.ifPresent(object::setCustomer);
    }

    private void setSubscriptionType(Subscription object)
    {
        if (object.getSubscriptionType() == null) return;
        Optional<SubscriptionType> subscriptionType = subscriptionTypeService.getEntityByKey(object.getSubscriptionType().getName());
        subscriptionType.ifPresent(object::setSubscriptionType);
    }

    @Override
    public void customerDeleted(Customer customer) {
        subscriptionRepository.updateCustomerDeleted(customer);
    }

    @Override
    public void subscriptionTypeDeleted(SubscriptionType subscriptionType) {
        subscriptionRepository.updateSubscriptionTypeDeleted(subscriptionType);
    }
}
