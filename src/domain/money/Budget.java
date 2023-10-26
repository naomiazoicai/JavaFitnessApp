package domain.money;

// Singleton
public class Budget {
    private static Budget instance;
    private double currentMoney;

    private Budget(){}
    public static Budget getInstance()
    {
        if (instance == null)
        {
            instance = new Budget();
        }
        return instance;
    };

    public double getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(double currentMoney) {
        this.currentMoney = currentMoney;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "currentMoney=" + currentMoney +
                '}';
    }


}
