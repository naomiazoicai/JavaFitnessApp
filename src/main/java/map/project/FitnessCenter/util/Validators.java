package map.project.FitnessCenter.util;

import lombok.NoArgsConstructor;
/**
 * Utility class for performing validations.
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Validators {
    public static boolean validateName(String name)
    {
        return name != null && !name.isEmpty();
    }
}
