
package enterprise;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "src/main/resources/staff.txt";

    public static void main(String[] args) {

        List<Employee> staff = StaticMethods.loadStaffFromFile(STAFF_TXT);

        System.out.println("Sorting with comparator by salary:\n");
        staff.sort(new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getSalary().compareTo(e2.getSalary());
            }
        });

        StaticMethods.printList(staff);
        System.out.println();

        System.out.println("Sorting with a lambda expression by salary\n");
        staff.sort((e1, e2) -> e1.getSalary().compareTo(e2.getSalary()));

        StaticMethods.printList(staff);
        System.out.println();

        System.out.println("Sorting with comparator and lambda expressions by salary and by name\n");
        StaticMethods.sortBySalaryAndAlphabet(staff);

        StaticMethods.printList(staff);
        System.out.println();
    }
}
