package lab3.problem_4;
import java.util.*;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("=================================================");
        System.out.println("         EMPLOYEE & MANAGER TEST SUITE           ");
        System.out.println("=================================================\n");

        @SuppressWarnings("deprecation")
        Date date2015 = new Date(115, 0, 10);
        @SuppressWarnings("deprecation")
        Date date2018 = new Date(118, 5, 1);
        @SuppressWarnings("deprecation")
        Date date2020 = new Date(120, 8, 15);
        @SuppressWarnings("deprecation")
        Date date2022 = new Date(122, 3, 20);

        Employee alice = new Employee("Alice", 55000.0, date2018, "AB123456C");
        Employee bob   = new Employee("Bob",   72000.0, date2015, "CD987654E");
        Employee carol = new Employee("Carol", 48000.0, date2022, "EF112233G");
        Employee dave  = new Employee("Dave",  72000.0, date2020, "GH445566I");

        Manager managerEve  = new Manager("Eve",  90000.0, date2015, "MN001122K", 15000.0);
        Manager managerFrank = new Manager("Frank", 90000.0, date2018, "OP334455L", 20000.0);

        managerEve.addEmployee(alice);
        managerEve.addEmployee(bob);
        managerFrank.addEmployee(carol);
        managerFrank.addEmployee(dave);

        System.out.println("--- 1. toString() ---");
        System.out.println(alice);
        System.out.println(bob);
        System.out.println(managerEve);
        System.out.println(managerFrank);
        System.out.println();

        System.out.println("--- 2. equals() ---");
        Employee aliceCopy = new Employee("Alice", 55000.0, date2018, "AB123456C");
        System.out.println("alice.equals(aliceCopy) [expect true ]: " + alice.equals(aliceCopy));
        System.out.println("alice.equals(bob)       [expect false]: " + alice.equals(bob));

        Manager eveCopy = new Manager("Eve", 90000.0, date2015, "MN001122K", 15000.0);
        eveCopy.addEmployee(alice);
        eveCopy.addEmployee(bob);
        System.out.println("managerEve.equals(eveCopy)   [expect true ]: " + managerEve.equals(eveCopy));
        System.out.println("managerEve.equals(managerFrank)[expect false]: " + managerEve.equals(managerFrank));
        System.out.println();

        System.out.println("--- 3. Comparable (sort employees by salary) ---");
        List<Employee> employees = new ArrayList<>(Arrays.asList(alice, bob, carol, dave));
        Collections.sort(employees);
        for (Employee e : employees)
            System.out.printf("  %-8s salary=%.0f%n", e.getName(), e.getAnnualSalary());
        System.out.println();

        System.out.println("--- 4. Comparable (sort managers: same salary, compare by bonus) ---");
        List<Manager> managers = new ArrayList<>(Arrays.asList(managerEve, managerFrank));
        Collections.sort(managers);
        for (Manager m : managers)
            System.out.printf("  %-8s salary=%.0f  bonus=%.0f%n",
                    m.getName(), m.getAnnualSalary(), m.getBonus());
        System.out.println();

        System.out.println("--- 5. Sort employees by Name ---");
        List<Employee> byName = new ArrayList<>(Arrays.asList(dave, carol, alice, bob));
        byName.sort(Employee.NAME_COMPARATOR);
        for (Employee e : byName)
            System.out.println("  " + e.getName());
        System.out.println();

        System.out.println("--- 6. Sort employees by Hire Date ---");
        List<Employee> byDate = new ArrayList<>(Arrays.asList(dave, carol, alice, bob));
        byDate.sort(Employee.HIRE_DATE_COMPARATOR);
        for (Employee e : byDate)
            System.out.printf("  %-8s hired=%s%n", e.getName(), e.getHireDate());
        System.out.println();

        System.out.println("--- 7. Clone Employee ---");
        Employee aliceClone = alice.clone();
        System.out.println("Original : " + alice);
        System.out.println("Clone    : " + aliceClone);
        System.out.println("alice == aliceClone             [expect false]: " + (alice == aliceClone));
        System.out.println("alice.equals(aliceClone)        [expect true ]: " + alice.equals(aliceClone));
        aliceClone.setAnnualSalary(99999.0);
        aliceClone.setName("AliceClone");
        System.out.println("After mutating clone:");
        System.out.println("  Original salary : " + alice.getAnnualSalary()      + "  (unchanged)");
        System.out.println("  Clone salary    : " + aliceClone.getAnnualSalary() + "  (changed)");
        System.out.println();

        System.out.println("--- 8. Clone Manager (deep clone) ---");
        Manager eveClone = managerEve.clone();
        System.out.println("Original manager : " + managerEve);
        System.out.println("Cloned manager   : " + eveClone);
        System.out.println("managerEve == eveClone           [expect false]: " + (managerEve == eveClone));
        System.out.println("managerEve.equals(eveClone)      [expect true ]: " + managerEve.equals(eveClone));
        eveClone.getTeam().get(0).setAnnualSalary(1.0);
        eveClone.getTeam().get(0).setName("Mutated");
        System.out.println("After mutating first team member of clone:");
        System.out.println("  Original team[0] name  : " + managerEve.getTeam().get(0).getName()
                + "  (unchanged - deep clone confirmed)");
        System.out.println("  Clone    team[0] name  : " + eveClone.getTeam().get(0).getName());
        System.out.println();

        System.out.println("--- 9. Copy Constructor ---");
        Employee bobCopy = new Employee(bob);
        System.out.println("bob     : " + bob);
        System.out.println("bobCopy : " + bobCopy);
        System.out.println("bob.equals(bobCopy) [expect true]: " + bob.equals(bobCopy));
        System.out.println();

        System.out.println("=================================================");
        System.out.println("              ALL TESTS COMPLETE                 ");
        System.out.println("=================================================");
    }
}
