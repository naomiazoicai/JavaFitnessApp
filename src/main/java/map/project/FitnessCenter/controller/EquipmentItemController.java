package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.service.BaseService;
import map.project.FitnessCenter.service.interfaces.IEquipmentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipmentItem")
public class EquipmentItemController extends BaseController<EquipmentItem, Long>
{
    private final IEquipmentItemService iEquipmentItemService;

    @Autowired
    public EquipmentItemController(BaseService<EquipmentItem, Long> iService, IEquipmentItemService iEquipmentItemService) {
        super(iService);
        this.iEquipmentItemService = iEquipmentItemService;
    }

    @PostMapping
    @Override
    public ResponseEntity<EquipmentItem> add(@RequestBody EquipmentItem object) {
        return super.add(object);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<EquipmentItem> update(@PathVariable(value = "id") Long id,@RequestBody EquipmentItem object) {
        return super.update(id, object);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<EquipmentItem> delete(@PathVariable(value = "id") Long id) {
        return super.delete(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<EquipmentItem>> getAll() {
        return super.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<EquipmentItem> getEntityById(@PathVariable(value = "id") Long id) {
        return super.getEntityById(id);
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<List<EquipmentItem>> getEntityByName(@PathVariable(value = "name") String name)
    {
        Optional<List<EquipmentItem>> result = iEquipmentItemService.getByName(name);
        if (result.isPresent())
        {
            List<EquipmentItem> list = result.get();
            if (list.isEmpty()) return ResponseEntity.notFound().build();
            else return ResponseEntity.ok().body(list);
        }
        return ResponseEntity.internalServerError().build();
    }
}
