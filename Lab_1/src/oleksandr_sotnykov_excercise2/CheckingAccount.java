package oleksandr_sotnykov_excercise2;

public class CheckingAccount {
    private String accountNumber;
    private String customerName;
    private double accountBalance;

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        if (accountBalance >= 50) {
            this.accountBalance = accountBalance;
        } else {
            System.out.println("Check your balance, at least $50 are supposed to remain on your account.");
        }
    }

    public CheckingAccount(String accountNumber, String customerName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountBalance = accountBalance;
    }

    public double withdraw(double amount) {
        if(this.accountBalance - (amount + 2) >= 50){
            this.accountBalance -= amount + 2;
            return this.accountBalance;
        }
        else{
            System.out.println("\nNot enough money to make an operation");
            return this.accountBalance;
        }
    }

    public String toString(){
        return "Account#: " + getAccountNumber() + "\nCustomer: " + getCustomerName() + "\nBalance: " + getAccountBalance();
    }
}
