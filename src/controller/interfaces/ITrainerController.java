package controller.interfaces;

import domain.persons.Trainer;

import java.util.ArrayList;

public interface ITrainerController {
    ArrayList<Trainer> searchByPartialUsername(String keyName);

    Trainer searchByUsername(String keyName);

    Boolean usernameInRepo(String keyName);
}
