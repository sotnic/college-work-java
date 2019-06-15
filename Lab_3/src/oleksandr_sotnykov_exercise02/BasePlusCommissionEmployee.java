package oleksandr_sotnykov_exercise02;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        if (baseSalary < 0.0D) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        } else {
            this.baseSalary = baseSalary;
        }
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0D) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        } else {
            this.baseSalary = baseSalary;
        }
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public double getPaymentAmount() {
        return this.getBaseSalary() + super.getPaymentAmount();
    }

    public String toString() {
        return String.format("%s %s%n%s: $%,.2f", "base-salaried", super.toString(), "base salary", this.getBaseSalary());
    }
}
