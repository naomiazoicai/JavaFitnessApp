package dao.interaces;

import domain.gym.SpecialisedRoom;


public interface ISpecialisedRoomDao
{
    Boolean idInRepo(int id);

    SpecialisedRoom searchById(int id);

    int generateNextId();
}
