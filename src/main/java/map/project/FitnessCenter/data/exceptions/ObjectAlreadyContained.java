package map.project.FitnessCenter.data.exceptions;

/**
 * Custom exception class indicating that an object is already contained.
 */
public class ObjectAlreadyContained extends Exception {
    public ObjectAlreadyContained() {
        super("Object already contained!");
    }
}
