
package enterprise;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StaticMethods {

    // convert TXT file to collection of 'employee' objects
    public static List<Employee> loadStaffFromFile(String path) {

        List<Employee> staff = new ArrayList<>();

        try {

            List<String> lines = Files.readAllLines(Paths.get(path));

            for (String line : lines) {

                String[] fragments = line.split("\t");

                if (fragments.length != 3) {

                    System.out.println("Wrong line: " + line);

                    continue;
                }

                String dateFormat = "dd.MM.yyyy";

                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return staff;
    }

    // sort 'employee' collection by salary and alphabetically
    public static void sortBySalaryAndAlphabet(List<Employee> staff) {

        staff.sort(((Comparator<Employee>) (e1, e2) -> e1.getSalary().compareTo(e2.getSalary()))
                .thenComparing((e1, e2) -> e1.getName().compareTo(e2.getName())));
    }

    // print the collection in the console
    public static void printList(List<Employee> staff) {

        for (Employee employee : staff) {
            System.out.println(employee);
        }
    }
}
