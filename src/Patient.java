import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Patient {
    private Map<String, Boolean> stats = new HashMap<>();

    public Patient(List<String> attribute, String patientData) {
        String[] data = patientData.split(" ");
        for (int i = 0; i < data.length; i++) {
            this.stats.put(attribute.get(i), Boolean.parseBoolean(data[i]));
        }
    }

}
