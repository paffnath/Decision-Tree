import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Patient {
    public String getPatientClass() {
        return patientClass;
    }

    public String patientClass;

    public Map<String, Boolean> getStats() {
        return stats;
    }

    private Map<String, Boolean> stats = new HashMap<>();

    public Patient(List<String> attribute, String patientData) {
        String[] data = patientData.split(" ");
        this.patientClass = data[0];
        for (int i = 1; i < data.length; i++) {
            this.stats.put(attribute.get(i), Boolean.parseBoolean(data[i]));
        }
    }

}
