package UI;

import controller.*;
import java.util.ArrayList;

public abstract class UI<Type> implements IUi, UiRun {
    final protected Controller<Type> controller;
    final protected Terminal terminal = Terminal.getInstance();

    protected UI(Controller<Type> controller){
        this.controller = controller;
    }

    @Override
    public void showAll() {
        ArrayList<Type> elements = controller.getAll();
        terminal.printArrayList(elements);
    }
}

