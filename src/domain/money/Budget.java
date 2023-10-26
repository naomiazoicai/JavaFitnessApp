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
            instance.currentMoney = 0;
        }
        return instance;
    };

    public void addMoney(int value)
    {
        currentMoney += value;
    }

    public void spendMoney(int value) throws Exception {
        if (value > currentMoney) throw new Exception("Expense exceeds budget");
        currentMoney -= value;
    }

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
