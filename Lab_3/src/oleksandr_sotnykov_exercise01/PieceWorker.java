package oleksandr_sotnykov_exercise01;

public class PieceWorker extends Employee {
    private double wage;
    private int piece;

    public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, int piece) {
        super(firstName, lastName, socialSecurityNumber);
        if (wage >= 0.0D && piece >= 0) {
            this.wage = wage;
            this.piece = piece;
        } else {
            throw new IllegalArgumentException("Wage and pieces are supposed to be more than or equal 0");
        }
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getWage() {
        return this.wage;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public int getPiece() {
        return this.piece;
    }

    public double earnings() {
        return (double)this.getPiece() * this.getWage();
    }

    public String toString() {
        return String.format("%s: %s%n%s: $%.2f%n%s: %d", "piece worker", super.toString(), "wage", this.getWage(), "pieces", this.getPiece());
    }
}

