package lab3.problem_4;
import java.util.Date;
import java.util.Objects;
import java.util.Vector;

public class Manager extends Employee {

    private Vector<Employee> team;
    private double bonus;

    public Manager() {
        super();
        this.team = new Vector<>();
        this.bonus = 0.0;
    }

    public Manager(String name, double annualSalary, Date hireDate,
                   String nationalInsuranceNumber, double bonus) {
        super(name, annualSalary, hireDate, nationalInsuranceNumber);
        this.team = new Vector<>();
        this.bonus = bonus;
    }

    public Manager(Manager other) throws CloneNotSupportedException {
        super(other);
        this.bonus = other.bonus;
        this.team = new Vector<>();
        for (Employee e : other.team) {
            this.team.add(e.clone());
        }
    }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    public Vector<Employee> getTeam() { return team; }

    public void addEmployee(Employee e) { team.add(e); }
    public void removeEmployee(Employee e) { team.remove(e); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Manager{")
          .append("name='").append(getName()).append('\'')
          .append(", annualSalary=").append(getAnnualSalary())
          .append(", hireDate=").append(getHireDate())
          .append(", nationalInsuranceNumber='").append(getNationalInsuranceNumber()).append('\'')
          .append(", bonus=").append(bonus)
          .append(", team=[");
        for (int i = 0; i < team.size(); i++) {
            sb.append(team.get(i).getName());
            if (i < team.size() - 1) sb.append(", ");
        }
        sb.append("]}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.bonus, bonus) == 0
                && Objects.equals(team, manager.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus, team);
    }

    @Override
    public int compareTo(Employee other) {
        int salaryComparison = super.compareTo(other);
        if (salaryComparison != 0) return salaryComparison;
        if (other instanceof Manager) {
            return Double.compare(this.bonus, ((Manager) other).bonus);
        }
        return salaryComparison;
    }

    @Override
    public Manager clone() throws CloneNotSupportedException {
        Manager cloned = (Manager) super.clone();
        cloned.team = new Vector<>();
        for (Employee e : this.team) {
            cloned.team.add(e.clone());
        }
        return cloned;
    }
}
