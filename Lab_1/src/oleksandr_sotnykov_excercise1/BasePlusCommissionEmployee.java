package oleksandr_sotnykov_excercise1;

public class BasePlusCommissionEmployee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private double baseSalary = 200;
    private double grossSales;
    private double commissionRate = 0.1;

    public int getEmployeeId() {
        return this.employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        if (lastName != null) {
            return this.lastName;
        } else {
            return "";
        }
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public double getGrossSales() {
        return this.grossSales;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales > 0) {
            this.grossSales = grossSales;
        } else {
            System.out.println("Sorry, cannot be negative!");
        }
    }

    public double getCommissionRate() {
        return this.commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate >= 0.1 && commissionRate <= 1) {
            this.commissionRate = commissionRate;
        } else {
            System.out.println("Sorry, your commission rate is out of range!");
        }
    }

    public BasePlusCommissionEmployee(int employeeId, String firstName, String lastName, double baseSalary, double grossSales, double commissionRate) {
        if (String.valueOf(employeeId) != null && employeeId > 0 && firstName != null && lastName != null && baseSalary > 0 && grossSales > 0 && commissionRate >= 0.1 && commissionRate <= 1.0) {
            this.employeeId = employeeId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.baseSalary = baseSalary;
            this.grossSales = grossSales;
            this.commissionRate = commissionRate;
        } else {
            System.out.println("\nSorry, your commission rate is out of range!");
            System.exit(1);
        }
    }

    public BasePlusCommissionEmployee(int employeeId, String firstName, double baseSalary) {
        if (String.valueOf(employeeId) != null && employeeId > 0 && firstName != null && baseSalary > 0) {
            this.employeeId = employeeId;
            this.firstName = firstName;
            this.baseSalary = baseSalary;
        } else {
            System.out.println("Incorrect Input!");
            System.exit(1);
        }
    }

    public double earnings() {
        return commissionRate * grossSales + baseSalary;
    }

    public String toString() {
        return getEmployeeId() + "." + getFirstName() + " " + getLastName() + "\nBase salary: $" + getBaseSalary() + "\nGross sales: $" + getGrossSales() + "\nCommission rate: " + getCommissionRate() + "\n";
    }
}