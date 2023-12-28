package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.EquipmentItem;
import map.project.FitnessCenter.service.BaseService;
import map.project.FitnessCenter.service.interfaces.IEquipmentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 * Controller class for managing equipment item-related operations in the fitness center.
 * This controller extends the BaseController and provides endpoints for common CRUD operations on EquipmentItem entities.
 * It also includes a specific endpoint for retrieving equipment items by name.
 **/
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
