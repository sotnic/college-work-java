package oleksandr_sotnykov_exercise03;

public class Main {

    public static void main(String[] args) {

        Invoice[] invoices = new Invoice[] {
                new Invoice("01234", "seat", 2, 375.0D),
                new Invoice("56789", "tire", 4, 79.95D)};
        Employee[] employees = new Employee[] {
               new SalariedEmployee("John", "Smith", "111-11-1111", 800.0D),
               new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000.0D, 0.06D),
               new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000.0D, 0.04D, 300.0D),
               new HourlyEmployee("Alex", "Sotnykov", "123-45-6789", 25.0D, 8.0D)};

        System.out.printf("Employees processed polymorphically:%n%n");
        Invoice[] var5 = invoices;
        int var6 = invoices.length;
        Employee[] var8 = employees;
        int var7 = employees.length;

        int i;
        for (i = 0; i < var6; ++i) {
            Invoice currentInvoice = var5[i];
            System.out.println(currentInvoice);
        }

        int j;
        for(j = 0; j < var7; ++j) {
            Employee currentEmployee = var8[j];
            System.out.println(currentEmployee);
            System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
        }
    }
}
