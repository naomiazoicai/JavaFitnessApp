package tests.domainTest;
import domain.money.Budget;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BudgetTest {
    @Test
    void testAddMoney()
    {
        Budget budget = Budget.getInstance();
        budget.setCurrentMoney(0);
        budget.addMoney(10);
        assertEquals(budget.getCurrentMoney(), 10);
    }

    @Test
    void testSpendMoney()
    {
        Budget budget = Budget.getInstance();
        budget.setCurrentMoney(200);
        assertThrows(Exception.class, () -> {
            budget.spendMoney(250);
        });
    }
}
