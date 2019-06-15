package oleksandr_sotnykov_exercise01;

public class HourlyEmployee extends Employee {
    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
        super(firstName, lastName, socialSecurityNumber);
        if (wage < 0.0D) {
            throw new IllegalArgumentException("Hourly employee hourly wage must be >= 0.0");
        } else if (hours >= 0.0D && hours <= 168.0D) {
            this.wage = wage;
            this.hours = hours;
        } else {
            throw new IllegalArgumentException("Hourly employee hours worked must be >= 0.0 and <= 168.0");
        }
    }

    public void setWage(double wage) {
        if (wage < 0.0D) {
            throw new IllegalArgumentException("Hourly employee hourly wage must be >= 0.0");
        } else {
            this.wage = wage;
        }
    }

    public double getWage() {
        return this.wage;
    }

    public double earnings() {
        return this.getWage() * this.hours;
    }

    public String toString() {
        return String.format("%s: %s%n%s: %.2f%n%s: %.2f", "hourly employee", super.toString(), "wage", this.getWage(), "working hours", this.hours);
    }
}
