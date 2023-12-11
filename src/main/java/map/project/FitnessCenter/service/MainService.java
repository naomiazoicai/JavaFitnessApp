package map.project.FitnessCenter.service;

import map.project.FitnessCenter.proxy.EquipmentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private final EquipmentProxy equipmentProxy;

    @Autowired
    public MainService(EquipmentProxy equipmentProxy) {
        this.equipmentProxy = equipmentProxy;
    }

    public void selectDatabaseRepository(boolean choice)
    {
        if (choice)
        {
            equipmentProxy.selectJpa();
        } else
        {
            equipmentProxy.selectInMemory();
        }
    }
}
