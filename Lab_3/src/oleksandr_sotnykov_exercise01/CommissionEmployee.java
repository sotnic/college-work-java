package oleksandr_sotnykov_exercise01;

public class CommissionEmployee extends Employee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate) {
        super(firstName, lastName, socialSecurityNumber);
        if (grossSales < 0.0D) {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        } else if (commissionRate > 0.0D && commissionRate < 1.0D) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.socialSecurityNumber = socialSecurityNumber;
            this.grossSales = grossSales;
            this.commissionRate = commissionRate;
        } else {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0D) {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        } else {
            this.grossSales = grossSales;
        }
    }

    public double getGrossSales() {
        return this.grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate > 0.0D && commissionRate < 1.0D) {
            this.commissionRate = commissionRate;
        } else {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }
    }

    public double getCommissionRate() {
        return this.commissionRate;
    }

    public double earnings() {
        return this.getCommissionRate() * this.getGrossSales();
    }

    public String toString() {
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", "commission employee", this.getFirstName(), this.getLastName(), "social security number", this.getSocialSecurityNumber(), "gross sales", this.getGrossSales(), "commission rate", this.getCommissionRate());
    }
}
