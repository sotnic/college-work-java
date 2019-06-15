package oleksandr_sotnykov_exercise03;

public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        if (weeklySalary < 0.0D) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        } else {
            this.weeklySalary = weeklySalary;
        }
    }

    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary < 0.0D) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        } else {
            this.weeklySalary = weeklySalary;
        }
    }

    public double getWeeklySalary() {
        return this.weeklySalary;
    }

    public double earnings() {
        return this.getWeeklySalary();
    }

    public String toString() {
        return String.format("salaried employee: %s%n%s: $%,.2f", super.toString(), "weekly salary", this.getWeeklySalary());
    }
}
