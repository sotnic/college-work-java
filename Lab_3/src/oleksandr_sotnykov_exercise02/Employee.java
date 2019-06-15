package oleksandr_sotnykov_exercise02;

public abstract class Employee implements Payable {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
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

    public String toString() {
        return String.format("%s %s%nsocial security number: %s", this.getFirstName(), this.getLastName(), this.getSocialSecurityNumber());
    }

    public abstract double getPaymentAmount();
}
