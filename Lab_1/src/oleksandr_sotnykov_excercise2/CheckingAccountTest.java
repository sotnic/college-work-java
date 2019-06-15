package oleksandr_sotnykov_excercise2;

public class CheckingAccountTest {
    public static void main(String[] args) {
        CheckingAccount account1 = new CheckingAccount("12345678", "Oleksandr Sotnykov", 500);
        CheckingAccount account2 = new CheckingAccount("87654321", "Jack Sparrow", 200);

        System.out.println("\n--- Account Information ---");

        System.out.println(account1.toString());
        System.out.println("\n" + account2.toString());

        System.out.println("\n--- Setting Balance ---");

        account1.setAccountBalance(300);
        System.out.println(account1.toString());

        account2.setAccountBalance(150);
        System.out.println("\n" +account2.toString());

        System.out.println("\n--- Withdrawing Money ---");
        account1.withdraw(50);
        System.out.println(account1.toString());
        account1.withdraw(5);
        System.out.println("\n" + account1.toString());

        account2.withdraw(50);
        System.out.println("\n" + account2.toString());
        account2.withdraw(70);
        System.out.println("\n" + account2.toString());
    }
}
