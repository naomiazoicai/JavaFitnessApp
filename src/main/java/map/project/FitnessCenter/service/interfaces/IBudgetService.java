package map.project.FitnessCenter.service.interfaces;

public interface IBudgetService {
    void addMoney(double amount);

    void spendMoney(double amount);

    String getBudget();
}
