package map.project.FitnessCenter.service.interfaces;

/**
 * An interface defining operations related to a budget.
 */
public interface IBudgetService {
    /**
     * Adds the specified amount of money to the budget.
     *
     * @param amount The amount of money to be added to the budget. Must be a non-negative value.
     */
    void addMoney(double amount);

    /**
     * Spends the specified amount of money from the budget.
     *
     * @param amount The amount of money to be spent from the budget. Must be a non-negative value.
     */
    void spendMoney(double amount);

    /**
     * Retrieves the current budget as a string representation.
     *
     * @return A string representation of the current budget.
     */
    String getBudget();
}
