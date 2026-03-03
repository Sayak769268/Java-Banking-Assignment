package paymentsystem;

public class UPIPayment extends BasePaymentWithGUI {

    private String upiId;

    public UPIPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    public void processPayment() {
        String record = "UPI | ID: " + upiId + " | Amount: ₹" + getAmount();
        showMessage("Processing UPI Payment...");
        showMessage(record);
        showMessage("Payment Successful!");
        TransactionManager.addTransaction(record);
    }
}