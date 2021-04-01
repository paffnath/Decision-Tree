import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        Set<Patient> patients = new HashSet<>();
        List<String> attributes;

        File train = new File("ass1_data/part2/hepatitis-training");

        Scanner sc = new Scanner(train);
        attributes = Arrays.asList(sc.nextLine().split(" "));

        while (sc.hasNextLine()) {

            patients.add(new Patient(attributes, sc.nextLine()));
        }
        sc.close();

        buildTree(patients, attributes);
    }


    public static void buildTree(Set<Patient> instances, List<String> attributes) {

        String bestAttribute = "";
        double bestImpurity = 1;
        Set<Patient> bestRightInstances = new HashSet<>();
        Set<Patient> bestLeftInstances = new HashSet<>();

        for (String attr : attributes) {
            Set<Patient> rightInstances = new HashSet<>();
            Set<Patient> leftInstances = new HashSet<>();
            for (Patient patient : instances) {
                if (patient.getStats().get(attr)) rightInstances.add(patient);
                else leftInstances.add(patient);
            }
            double totalWeightedImpurity = calculateWeightedImpurity(rightInstances, leftInstances);
            if (totalWeightedImpurity < bestImpurity) {
                bestAttribute = attr;
                bestImpurity = totalWeightedImpurity;
                bestRightInstances = rightInstances;
                bestLeftInstances = leftInstances;
            }

        }
        attributes.remove(bestAttribute);
        buildTree(bestLeftInstances, attributes);
        buildTree(bestRightInstances, attributes);

    }


    public static double calculateWeightedImpurity(Set<Patient> right, Set<Patient> left) {
        double rightImpurity = calculateImpurity(right);
        double leftImpurity = calculateImpurity(left);
        double totalsize = right.size() + left.size();

        double rightWeightedImpurity = rightImpurity * (right.size() / totalsize);
        double leftWeightedImpurity = leftImpurity * (left.size() / totalsize);
        return rightWeightedImpurity + leftWeightedImpurity;

    }

    public static double calculateImpurity(Set<Patient> patients) {
        double alive = 0;
        double dead = 0;

        for (Patient patient : patients) {
            if (patient.getPatientClass().equals("live")) alive++;
            else dead++;
        }
        double size = alive + dead;
        return (dead / size) * (alive / size);

    }
}
