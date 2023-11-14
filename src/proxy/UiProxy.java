package proxy;

import UI.SpecialisedUIs.UiTypes;
import UI.UiRunnable;
import factory.UiRunnableFactory;

// This proxy initialises the UI only when it is needed
public class UiProxy implements UiRunnable {
    private final UiTypes uiType;
    private UiRunnable ui;

    public UiProxy(UiTypes uiType)
    {
        this.uiType = uiType;
    }

    @Override
    public void run()
    {
        if (ui == null) ui = UiRunnableFactory.buildUi(uiType);
        ui.run();
    }
}
