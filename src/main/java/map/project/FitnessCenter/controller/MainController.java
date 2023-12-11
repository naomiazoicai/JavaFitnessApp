package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private final MainService service;

    @Autowired
    MainController(MainService service)
    {
        this.service = service;
    }

    @GetMapping("")
    public String welcome()
    {
        return "Welcome! Please select repository type.";
    }

    @PostMapping("/selectRepository/{value}")
    public String selectRepositoryType(@PathVariable(value = "value") String value)
    {
        System.out.println("Here");
        if (value.equals("jpa"))
        {
            service.selectDatabaseRepository(true);
            return "Jpa repository selected..";
        }
        else
        {
            service.selectDatabaseRepository(false);
            return "In memory repository selected..";
        }

    }
}
