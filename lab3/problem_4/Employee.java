package lab3.problem_4;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class Employee extends Person implements Comparable<Employee>, Cloneable {

    private double annualSalary;
    private Date hireDate;
    private String nationalInsuranceNumber;

    public Employee() {
        super();
        this.annualSalary = 0.0;
        this.hireDate = new Date();
        this.nationalInsuranceNumber = "N/A";
    }

    public Employee(String name, double annualSalary, Date hireDate, String nationalInsuranceNumber) {
        super(name);
        this.annualSalary = annualSalary;
        this.hireDate = new Date(hireDate.getTime());
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public Employee(Employee other) {
        super(other);
        this.annualSalary = other.annualSalary;
        this.hireDate = new Date(other.hireDate.getTime());
        this.nationalInsuranceNumber = other.nationalInsuranceNumber;
    }

    public double getAnnualSalary() { return annualSalary; }
    public void setAnnualSalary(double annualSalary) { this.annualSalary = annualSalary; }

    public Date getHireDate() { return new Date(hireDate.getTime()); }
    public void setHireDate(Date hireDate) { this.hireDate = new Date(hireDate.getTime()); }

    public String getNationalInsuranceNumber() { return nationalInsuranceNumber; }
    public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "name='" + getName() + '\''
                + ", annualSalary=" + annualSalary
                + ", hireDate=" + hireDate
                + ", nationalInsuranceNumber='" + nationalInsuranceNumber + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.annualSalary, annualSalary) == 0
                && Objects.equals(hireDate, employee.hireDate)
                && Objects.equals(nationalInsuranceNumber, employee.nationalInsuranceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), annualSalary, hireDate, nationalInsuranceNumber);
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.annualSalary, other.annualSalary);
    }

    public static final Comparator<Employee> NAME_COMPARATOR =
            Comparator.comparing(Employee::getName);

    public static final Comparator<Employee> HIRE_DATE_COMPARATOR =
            Comparator.comparing(Employee::getHireDate);

    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.hireDate = new Date(this.hireDate.getTime());
        return cloned;
    }
}
