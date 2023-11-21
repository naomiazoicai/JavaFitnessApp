package dao.interaces;

import domain.persons.Trainer;

import java.util.ArrayList;

public interface ITrainerDao {
    Boolean keyNameInRepo(String keyName);

    Trainer searchByKeyName(String keyName);

    ArrayList<Trainer> searchByPartialKeyName(String keyName);
}
