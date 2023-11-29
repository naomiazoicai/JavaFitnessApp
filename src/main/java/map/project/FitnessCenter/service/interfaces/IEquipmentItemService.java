package map.project.FitnessCenter.service.interfaces;

import map.project.FitnessCenter.data.model.EquipmentItem;

import java.util.Optional;

public interface IEquipmentItemService {
    Optional<EquipmentItem> getByName(String name);
}
