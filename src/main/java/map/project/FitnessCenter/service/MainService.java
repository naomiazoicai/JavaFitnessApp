package map.project.FitnessCenter.service;

import map.project.FitnessCenter.factory.RepoTypes;
import map.project.FitnessCenter.proxy.EquipmentItemRepositoryProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for selecting the repository type of the fitness center app.
 */
@Service
public class MainService {
    private final EquipmentItemRepositoryProxy equipmentItemRepositoryProxy;

    @Autowired
    public MainService(EquipmentItemRepositoryProxy equipmentItemRepositoryProxy) {
        this.equipmentItemRepositoryProxy = equipmentItemRepositoryProxy;
    }

    public void selectRepoType(RepoTypes type)
    {

        switch (type)
        {
            case inMemory -> equipmentItemRepositoryProxy.selectInMemory();
            case jpa -> equipmentItemRepositoryProxy.selectJpa();
        }
    }

    public String welcome()
    {
        return "Welcome! Please select repository type.";
    }
}
