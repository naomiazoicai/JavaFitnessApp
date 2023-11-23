package repository.interfaces;

import domain.gym.SpecialisedRoom;

public interface ISpecialisedRoomRepository {
    Boolean idInRepo(int id);

    SpecialisedRoom searchById(int id);

    int generateNextId();
}
