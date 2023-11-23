package dao.interaces;

import domain.persons.Trainer;

import java.util.ArrayList;

public interface ITrainerDao {
    Boolean usernameInRepo(String keyName);

    Trainer searchByUsername(String keyName);

    ArrayList<Trainer> searchByPartialUsername(String keyName);
}
