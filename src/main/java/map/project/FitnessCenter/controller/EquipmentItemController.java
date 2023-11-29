package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.EquipmentItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipmentItemController extends Controller<EquipmentItem>
{
    @PostMapping("/equipmentItem")
    @Override
    public ResponseEntity<EquipmentItem> add(@RequestBody EquipmentItem object) {
        return super.add(object);
    }

    @PutMapping("/equipmentItem/{id}")
    @Override
    public ResponseEntity<EquipmentItem> update(@PathVariable(value = "id") Long id,@RequestBody EquipmentItem object) {
        return super.update(id, object);
    }

    @DeleteMapping("/equipmentItem/{id}")
    @Override
    public ResponseEntity<EquipmentItem> delete(@PathVariable(value = "id") Long id) {
        return super.delete(id);
    }

    @GetMapping("/equipmentItem")
    @Override
    public ResponseEntity<List<EquipmentItem>> getAll() {
        return super.getAll();
    }

    @GetMapping(("/equipmentItem/{id}"))
    @Override
    public ResponseEntity<EquipmentItem> getEntityById(@PathVariable(value = "id") Long id) {
        return super.getEntityById(id);
    }
}
