import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        DecisionTree decisionTree = new DecisionTree();

        File train = new File("ass1_data/part2/hepatitis-training");

        Scanner sc = new Scanner(train);
        decisionTree.attributes = Arrays.asList( sc.nextLine().split(" "));

        while (sc.hasNextLine()) {

            decisionTree.patients.add(new Patient(sc.nextLine()));
        }
        sc.close();


    }

    public Patient createPatient(String line){


        return patient;
    }
}
