package repository.interfaces;

import domain.persons.Trainer;

import java.util.ArrayList;

public interface ITrainerRepository {
    Boolean usernameInRepo(String keyName);

    ArrayList<Trainer> searchByPartialUsername(String keyName);

    Trainer searchByUsername(String keyName);
}
