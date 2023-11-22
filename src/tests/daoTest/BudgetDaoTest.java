package tests.daoTest;

import dao.BudgetDao;
import dao.DatabaseConnection;
import domain.money.Budget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class BudgetDaoTest {
    private BudgetDao budgetDao;

    @BeforeEach
    public void setUp() {
        // Connect to database
        try {
            DatabaseConnection.setConnection("jdbc:mysql://localhost:3306/testjavaapp", "coders", "ThisIsOurDatabase.2023");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        // Get database
        budgetDao = BudgetDao.getInstance();
    }

    @Test
    public void testAddMoney() {
        double initialMoney = budgetDao.getCurrentMoney();

        // Add money to the budget
        double addedMoney = 100.0;
        budgetDao.addMoney(addedMoney);

        // Check if the current money has been updated
        assertEquals(initialMoney + addedMoney, budgetDao.getCurrentMoney(), 0.01);
    }

    @Test
    public void testSpendMoney() {
        double initialMoney = budgetDao.getCurrentMoney();

        // Spend money from the budget
        double spentMoney = 50.0;
        try {
            budgetDao.spendMoney(spentMoney);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }

        // Check if the current money has been updated
        assertEquals(initialMoney - spentMoney, budgetDao.getCurrentMoney(), 0.01);
    }

    @Test
    public void testGetCurrentMoney() {
        // Get the current money from the budget
        double currentMoney = budgetDao.getCurrentMoney();

        // Check if the retrieved value matches the initial value
        assertEquals(Budget.getInstance().getCurrentMoney(), currentMoney, 0.01);
    }

    @Test
    public void testBudgetAsString() {
        // Check if the string representation is not null
        assertNotNull(budgetDao.budgetAsString());
    }


}
