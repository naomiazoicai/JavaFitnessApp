package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.data.model.enums.MoneyValue;
import map.project.FitnessCenter.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/budget")
public class BudgetController {
    private final BudgetService service;

    @Autowired
    public BudgetController(BudgetService service)
    {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<String> getBudget()
    {
        return ResponseEntity.ok(service.getBudget());
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody MoneyValue moneyValue)
    {
        String response = "Old budget --->   " + service.getBudget() + "\n";
        service.addMoney(moneyValue.getAmount());
        response += "New budget --->   " + service.getBudget();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/spend")
    public ResponseEntity<String> spend(@RequestBody MoneyValue moneyValue)
    {
        String response = "Old budget --->   " + service.getBudget() + "\n";
        service.spendMoney(moneyValue.getAmount());
        response += "New budget --->   " + service.getBudget();
        return ResponseEntity.ok(response);
    }
}
