package dao;

import domain.money.Budget;
import domain.money.SubscriptionType;
import repository.exceptions.ObjectNotContained;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BudgetDao
{
    private final Connection connection = DatabaseConnection.getConnection();

    private static BudgetDao instance;

    private final Budget budget;

    private BudgetDao()
    {
        budget = Budget.getInstance();
        initialiseBudget();
    }

    public static BudgetDao getInstance()
    {
        if (instance == null) instance = new BudgetDao();
        return instance;
    }

    private void initialiseBudget()
    {
        try {
            String query = "SELECT * FROM budget;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            // Analyse result
            if (resultSet.next())
            {
                budget.setCurrentMoney(resultSet.getDouble("currentMoney"));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMoney(double value)
    {
        budget.addMoney(value);
        try {
            String updateQuery = "UPDATE budget SET currentMoney = ? WHERE id = 0";
            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.setDouble(1, budget.getCurrentMoney());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void spendMoney(double value) throws Exception
    {
        budget.spendMoney(value);
        try {
            String updateQuery = "UPDATE budget SET currentMoney = ? WHERE id = 0";
            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.setDouble(1, budget.getCurrentMoney());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public double getCurrentMoney()
    {
        try {
            String query = "SELECT * FROM budget;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            // Analyse result
            if (resultSet.next())
            {
                return resultSet.getDouble("currentMoney");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException("Database corrupted");
    }

    public String budgetAsString()
    {
        return budget.toString();
    }
}
