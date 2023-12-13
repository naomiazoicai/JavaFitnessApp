package map.project.FitnessCenter.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
public class Budget {
    @Id
    private Integer id;
    @Column(nullable = false)
    private double currentMoney;

    public Budget copy()
    {
        return new Budget(id, currentMoney);
    }

    public void addMoney(double value)
    {
        currentMoney += value;
    }

    public void spendMoney(double value)
    {
        currentMoney -= value;
    }
}
