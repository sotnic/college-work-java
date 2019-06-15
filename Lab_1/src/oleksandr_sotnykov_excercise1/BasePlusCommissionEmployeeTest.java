package oleksandr_sotnykov_excercise1;

public class BasePlusCommissionEmployeeTest {
    public static void main(String[] args) {
        BasePlusCommissionEmployee employee1 = new BasePlusCommissionEmployee(101,"Oleksandr", "Sotnykov", 4500, 1300, 0.5);
        BasePlusCommissionEmployee employee2 = new BasePlusCommissionEmployee(102,"John", 3000);

        System.out.println("\n--- Employee Information ---");
        System.out.println(employee1.toString());
        System.out.println(employee2.toString());

        System.out.println("--- Setting Gross Sales in Dollars ---");
        employee1.setGrossSales(500);
        System.out.println(employee1.toString());
        employee2.setGrossSales(250);
        System.out.println(employee2.toString());

        System.out.println("--- Setting Commission Rate ---");
        employee1.setCommissionRate(0.7);
        System.out.println(employee1.toString());
        employee2.setCommissionRate(7);
        System.out.println(employee2.toString());

        System.out.println("--- Total Income ---");
        System.out.printf("%s %s: $%s", employee1.getFirstName(), employee1.getLastName(), employee1.earnings());
        System.out.printf("\n%s %s: $%s", employee2.getFirstName(), employee2.getLastName(), employee2.earnings());
    }
}