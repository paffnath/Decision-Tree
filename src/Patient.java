import java.util.HashMap;
import java.util.Map;

public class Patient {
    private Map<String, Boolean> stats = new HashMap<>();

    public Patient(){

    }

    public Patient(Map<String, Boolean> stats) {
        this.stats = stats;
    }
}
