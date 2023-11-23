package proxy;

import UI.SpecialisedUIs.UiTypes;
import UI.UiRun;
import factory.UiRunFactory;

// This proxy initialises the UI only when it is needed
public class UiProxy implements UiRun {
    private final UiTypes uiType;
    private UiRun ui;

    public UiProxy(UiTypes uiType)
    {
        this.uiType = uiType;
    }

    @Override
    public void run()
    {
        if (ui == null) ui = UiRunFactory.buildUi(uiType);
        ui.run();
    }
}
