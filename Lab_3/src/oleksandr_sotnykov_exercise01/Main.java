package oleksandr_sotnykov_exercise01;

public class Main {

    public static void main(String[] args) {
        SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.0D);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000.0D, 0.06D);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000.0D, 0.04D, 300.0D);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Alex", "Sotnykov", "123-45-6789", 3000.0D, 8.0D);
        PieceWorker pieceWorker = new PieceWorker("Lola", "Kane", "444-44-4444", 25.0D, 20);

        System.out.println("Employees processed individually:");
        System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee, "earned", salariedEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n", commissionEmployee, "earned", commissionEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n", basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());
        Employee[] employees = new Employee[]{salariedEmployee, commissionEmployee, hourlyEmployee, pieceWorker};
        System.out.printf("Employees processed polymorphically:%n%n");
        Employee[] var8 = employees;
        int var7 = employees.length;

        int j;
        for(j = 0; j < var7; ++j) {
            Employee currentEmployee = var8[j];
            System.out.println(currentEmployee);
            System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
        }

        for(j = 0; j < employees.length; ++j) {
            System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
        }

    }
}
