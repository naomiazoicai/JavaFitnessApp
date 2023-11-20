package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDao {
    public static void getAllSubscriptionTypes()
    {
        try {
            Connection connection = DatabaseConnection.getConnection();

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM SubscriptionType");
            while (resultSet.next()) {
                String name;
                String description;
                double price;
                name = resultSet.getString("name");
                description = resultSet.getString("description");
                price = resultSet.getDouble("price");
                System.out.println("Name: " + name + "\t\tDescription: " + description + "\t\tPrice: " + price);
            }
            resultSet.close();
            statement.close();
            connection.close();


        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
