package UI;

public class MainUI {
    private static MainUI instance;

    private MainUI(){}

    public static MainUI getInstance()
    {
        if (instance == null) instance = new MainUI();
        return instance;
    }
    public void runUi()
    {
        //TODO
    }
}
