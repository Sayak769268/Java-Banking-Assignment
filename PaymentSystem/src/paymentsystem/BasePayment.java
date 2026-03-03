package paymentsystem;

public abstract class BasePayment implements Payment {

    private double amount;   // encapsulated (hidden)

    public BasePayment(double amount) {
        setAmount(amount);   // validation through setter
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        this.amount = amount;
    }
}