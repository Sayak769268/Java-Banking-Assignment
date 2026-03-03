package paymentsystem;

public class CreditCardPayment extends BasePaymentWithGUI {

    private String cardNumber;

    public CreditCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment() {
        String record = "Credit Card | Card: " + cardNumber + " | Amount: ₹" + getAmount();
        showMessage("Processing Credit Card Payment...");
        showMessage(record);
        showMessage("Payment Successful!");
        TransactionManager.addTransaction(record);
    }
}