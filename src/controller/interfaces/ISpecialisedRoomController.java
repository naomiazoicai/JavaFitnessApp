package controller.interfaces;

import domain.gym.SpecialisedRoom;

public interface ISpecialisedRoomController {
    boolean idInRepo(int id);

    SpecialisedRoom searchById(int id);
}
