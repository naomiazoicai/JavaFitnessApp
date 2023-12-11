package map.project.FitnessCenter.service;

import map.project.FitnessCenter.factory.RepoTypes;
import map.project.FitnessCenter.proxy.EquipmentItemProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private final EquipmentItemProxy equipmentItemProxy;

    @Autowired
    public MainService(EquipmentItemProxy equipmentItemProxy) {
        this.equipmentItemProxy = equipmentItemProxy;
    }

    public void selectRepoType(RepoTypes type)
    {

        switch (type)
        {
            case inMemory -> equipmentItemProxy.selectInMemory();
            case jpa -> equipmentItemProxy.selectJpa();
        }
    }
}
