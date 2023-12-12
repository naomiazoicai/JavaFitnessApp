package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.Customer;
import map.project.FitnessCenter.data.model.Trainer;
import map.project.FitnessCenter.data.repository.Jpa.CustomerRepository;
import map.project.FitnessCenter.data.repository.Jpa.PersonRepository;
import map.project.FitnessCenter.data.repository.intefaces.ICustomerRepository;
import map.project.FitnessCenter.service.interfaces.ITrainerService;
import map.project.FitnessCenter.service.observers.IObserverDeletedCustomer;
import map.project.FitnessCenter.service.observers.IObserverDeletedTrainer;
import map.project.FitnessCenter.service.subjects.ISubjectDeletedCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService extends PersonService<Customer> implements IObserverDeletedTrainer, ISubjectDeletedCustomer {
    private final ICustomerRepository customerRepository;
    private final ITrainerService trainerService;

    @Autowired
    public CustomerService(CustomerRepository repository, PersonRepository personRepository,
                           TrainerService trainerService)
    {
        super(repository, personRepository);
        this.customerRepository = repository;
        this.trainerService = trainerService;
        trainerService.addObserver(this);
    }

    @Override
    public Optional<Customer> add(Customer object) throws ObjectAlreadyContained {
        setTrainer(object);
        return super.add(object);
    }

    @Override
    public Optional<Customer> update(String id, Customer object) throws ObjectNotContained, ObjectAlreadyContained {
        // TODO if (!repository.existsById(id)) throw new ObjectNotContained();
        Optional<Customer> oldObject = repository.findById(id).map(Customer::copy);
        setTrainer(object);
        object.setUsername(id);
        repository.save(object);
        return oldObject;
    }

    @Override
    public Optional<Customer> delete(String id) throws ObjectNotContained {
        repository.findById(id).ifPresent(this::notifyCustomerDeleted);
        return super.delete(id);
    }

    private void setTrainer(Customer object)
    {
        if (object.getAssignedTrainer() == null) return;
        String trainerUsername = object.getAssignedTrainer().getUsername();
        Trainer trainer = trainerService.getTrainerByUsername(trainerUsername);
        object.setAssignedTrainer(trainer);
    }

    @Override
    public void trainerDeleted(Trainer trainer) {
        customerRepository.trainerDeleted(trainer);
    }

    @Override
    public void addObserver(IObserverDeletedCustomer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserverDeletedCustomer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyCustomerDeleted(Customer customer) {
        for (IObserverDeletedCustomer observer : observerList) observer.customerDeleted(customer);
    }
}
