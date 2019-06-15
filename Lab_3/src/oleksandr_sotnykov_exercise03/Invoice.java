package oleksandr_sotnykov_exercise03;

public class Invoice implements Payable {
    private final String partNumber;
    private final String partDescription;
    private final int quantity;
    private final double pricePerItem;

    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be >= 0");
        } else if (pricePerItem < 0.0D) {
            throw new IllegalArgumentException("Price per item must be >= 0");
        } else {
            this.quantity = quantity;
            this.partNumber = partNumber;
            this.partDescription = partDescription;
            this.pricePerItem = pricePerItem;
        }
    }

    public String getPartNumber() {
        return this.partNumber;
    }

    public String getPartDescription() {
        return this.partDescription;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPricePerItem() {
        return this.pricePerItem;
    }

    public String toString() {
        return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f%n", "invoice", "part number", this.getPartNumber(), this.getPartDescription(), "quantity", this.getQuantity(), "price per item", this.getPricePerItem());
    }

    public double getPaymentAmount() {
        return (double)this.getQuantity() * this.getPricePerItem();
    }
}
