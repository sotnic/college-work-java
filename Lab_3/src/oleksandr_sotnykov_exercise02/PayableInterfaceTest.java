package oleksandr_sotnykov_exercise02;

public class PayableInterfaceTest {

    public static void main(String[] args) {

        // declaring the new array of interface Payable
        Payable[] payableObjects = new Payable[]{
                new Invoice("01234", "seat", 2, 375.0D),
                new Invoice("56789", "tire", 4, 79.95D),
                new SalariedEmployee("John", "Smith", "111-11-1111", 800.0D),
                new HourlyEmployee("Lisa", "Barnes", "888-88-8888", 22.0D, 10.0D),
                new CommissionEmployee("Joey", "Tribiani", "111-11-1111", 1000.0D, 0.08D),
                new BasePlusCommissionEmployee("Chandler", "Bing", "222-22-2222", 3000.0D, 0.07D, 4000.0D)};

        System.out.println("Invoices and Employees processed polymorphically:");
        Payable[] var5 = payableObjects;
        int var4 = payableObjects.length;

        // displaying each object of the array
        for(int i = 0; i < var4; ++i) {
            Payable currentPayable = var5[i];
            System.out.printf("%n%s %npayment due: $%,.2f%n", currentPayable.toString(), currentPayable.getPaymentAmount());

            // modification of the objects which are instance of BasePlusCommissionEmployee and HourlyEmployee
            if (currentPayable instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee)currentPayable;
                employee.setBaseSalary(1.1D * employee.getBaseSalary());
                System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
            } else if (currentPayable instanceof HourlyEmployee) {
                HourlyEmployee employee = (HourlyEmployee)currentPayable;
                employee.setWage(employee.getWage() + 2.0D);
                System.out.printf("new wage with $2 increase is: $%,.2f%n", employee.getWage());
            }
        }
    }
}
