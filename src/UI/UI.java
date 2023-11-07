package UI;

import controller.*;
import domain.gym.*;
import domain.persons.Customer;
import domain.persons.Trainer;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import javax.naming.ldap.Control;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class UI<Type> implements IUi<Type>{
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

