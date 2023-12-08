package map.project.FitnessCenter.service.interfaces;

import map.project.FitnessCenter.data.model.EquipmentItem;

import java.util.List;
import java.util.Optional;

public interface IEquipmentItemService {
    Optional<List<EquipmentItem>> getByName(String name);
}
